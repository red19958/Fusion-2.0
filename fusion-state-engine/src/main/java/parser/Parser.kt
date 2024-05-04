package parser

import android.util.Log
import attributes.FlowRowAttributes
import attributes.ImageAttributes
import attributes.TextAttributes
import attributes.TextFieldAttributes
import grammar.DSLGrammarParser.*
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes
import grammar.DSLGrammarLexer
import grammar.DSLGrammarParser
import nodes.ImageNode
import nodes.Node
import nodes.TextFieldNode
import nodes.TextNode
import nodes.layout.BoxNode
import nodes.layout.ColumnNode
import nodes.layout.FlowRowNode
import nodes.layout.LayoutNode
import nodes.layout.lazy.LazyColumnNode
import nodes.layout.lazy.LazyRowNode
import nodes.layout.RowNode
import nodes.layout.lazy.Parts
import nodes.layout.lazy.Parts.Item
import nodes.layout.lazy.Parts.Items
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import util.State
import types.Align
import types.AnimateChanges
import types.Background
import types.Border
import types.Config
import types.CornersRadius
import types.Dimension
import types.FontStyle
import types.Gravity
import types.GravityEnum
import types.ImeAction
import types.Insets
import types.KeyboardCapitalization
import types.KeyboardOptions
import types.KeyboardType
import types.Overflow
import types.ResizeMode
import types.expressions.*
import util.FList
import util.FMap


object Parser {
    fun parse(string: String): Pair<Node, State> {
        val charStream = CharStreams.fromString(string)
        val lexer = DSLGrammarLexer(charStream)
        val parser = DSLGrammarParser(CommonTokenStream(lexer))
        val grammarInfo = parser.start()
        val state = parseFields(grammarInfo)
        val node = parseTokens(grammarInfo, mutableListOf()).first()
        return node to state
    }

    private fun parseTokens(tokens: ParseTree, result: MutableList<Node>): List<Node> {
        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is BoxContext -> {
                    val attributes = parseBaseAttributes(temp)

                    result.add(
                        BoxNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            mutableListOf(),
                        )
                    )
                }

                is ColumnContext -> {
                    val attributes = parseBaseAttributes(temp)

                    result.add(
                        ColumnNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            mutableListOf(),
                        )
                    )
                }

                is RowContext -> {
                    val attributes = parseBaseAttributes(temp)

                    result.add(
                        RowNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            mutableListOf(),
                        )
                    )
                }

                is LazyColumnContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val partsList = mutableListOf<Parts>()

                    for (j in 0 until temp.childCount) {
                        val cur = temp.getChild(j)

                        when (cur.payload) {
                            is ItemsContext -> {
                                val child = parseTokens(cur.getChild(5), mutableListOf()).first()
                                val tokensForValue = cur.getChild(2)
                                val items = Items(ExpressionWithValue(), child)

                                if (tokensForValue.payload is FieldExprContext) {
                                    items.size.expression = parseFieldExpr(tokensForValue)
                                } else {
                                    items.size.value = parseFLong(tokensForValue).toInt()
                                }

                                partsList.add(items)
                            }

                            is ItemContext -> {
                                val child = parseTokens(cur.getChild(2), mutableListOf()).first()
                                partsList.add(Item(child))
                            }

                            else -> continue
                        }
                    }

                    result.add(
                        LazyColumnNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            partsList,
                        )
                    )

                    continue
                }

                is LazyRowContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val partsList = mutableListOf<Parts>()

                    for (j in 0 until temp.childCount) {
                        val cur = temp.getChild(j)

                        when (cur.payload) {
                            is ItemsContext -> {
                                val child = parseTokens(cur.getChild(5), mutableListOf()).first()
                                val tokensForValue = cur.getChild(2)
                                val items = Items(ExpressionWithValue(), child)

                                if (tokensForValue.payload is FieldExprContext) {
                                    items.size.expression = parseFieldExpr(tokensForValue)
                                } else {
                                    items.size.value = parseFLong(tokensForValue).toInt()
                                }

                                partsList.add(items)
                            }

                            is ItemContext -> {
                                val child = parseTokens(cur.getChild(2), mutableListOf()).first()
                                partsList.add(Item(child))
                            }

                            else -> continue
                        }
                    }

                    result.add(
                        LazyRowNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            partsList,
                        )
                    )

                    continue
                }

                is FlowRowContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val flowRowAttributes = parseFlowRowAttributes(temp)

                    result.add(
                        FlowRowNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            flowRowAttributes,
                            mutableListOf(),
                        )
                    )
                }

                is TextNodeContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val textAttr = parseTextAttributes(temp)

                    result.add(
                        TextNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            textAttr,
                        )
                    )
                }

                is TextFieldNodeContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val textFieldAttr = parseTextFieldAttributes(temp)

                    result.add(
                        TextFieldNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            textFieldAttr,
                        )
                    )
                }

                is ImageNodeContext -> {
                    val attributes = parseBaseAttributes(temp)
                    val imageAttr = parseImageAttributes(temp)

                    result.add(
                        ImageNode(
                            attributes.first,
                            attributes.second,
                            attributes.third,
                            imageAttr,
                        )
                    )
                }

                is LayoutNodeContext -> {
                    if (result.isEmpty()) {
                        parseTokens(temp, result)
                    } else {
                        when (result.first()) {
                            is LayoutNode -> {
                                (result.first() as LayoutNode).children.addAll(
                                    parseTokens(
                                        temp,
                                        mutableListOf(),
                                    )
                                )
                            }
                        }

                    }

                    continue
                }

                is NodeContext -> {
                    if (result.isEmpty()) {
                        parseTokens(temp, result)
                    } else {
                        (result.first() as LayoutNode).children.addAll(
                            parseTokens(
                                temp,
                                mutableListOf(),
                            )
                        )
                    }

                    continue
                }

                else -> continue
            }

            parseTokens(temp, result)
        }

        return result
    }

    private fun parseFields(tokens: ParseTree): State {
        val state = State()

        for (i in 0 until tokens.childCount) {
            val field = tokens.getChild(i)

            if (field !is FieldsContext) break
            val name = field.getChild(1).text
            val typeValue = field.getChild(3)
            val type =
                typeValue.getChild(0).payload as? CommonToken ?: throw IllegalArgumentException(
                    ILLEGAL_ARGUMENT + FIELDS
                )

            when (val a = DSLGrammarLexer.VOCABULARY.getDisplayName(type.type)) {
                ARRAY -> {
                    val fArray = typeValue.getChild(1)
                    val arr: FList<*>
                    val tokensForValue = fArray.getChild(1)

                    when (tokensForValue.payload) {
                        is FstringArrValueContext -> {
                            arr = parseArray(tokensForValue, ::parseFString)
                            state[name] = arr
                        }

                        is FbooleanArrValueContext -> {
                            arr = parseArray(tokensForValue, ::parseFBoolean)
                            state[name] = arr
                        }

                        is FdoubleArrValueContext -> {
                            arr = parseArray(tokensForValue, ::parseFDouble)
                            state[name] = arr
                        }

                        is FlongArrValueContext -> {
                            arr = parseArray(tokensForValue, ::parseFLong)
                            state[name] = arr
                        }
                    }
                }

                DICTIONARY -> {
                    val fDict = typeValue.getChild(1)
                    val dict: FMap<*>
                    val tokensForValue = fDict.getChild(1)

                    when (tokensForValue.payload) {
                        is FstringDictValueContext -> {
                            dict = parseDictionary(tokensForValue, ::parseFString)
                            state[name] = dict
                        }

                        is FbooleanDictValueContext -> {
                            dict = parseDictionary(tokensForValue, ::parseFBoolean)
                            state[name] = dict
                        }

                        is FdoubleDictValueContext -> {
                            dict = parseDictionary(tokensForValue, ::parseFDouble)
                            state[name] = dict
                        }

                        is FlongDictValueContext -> {
                            dict = parseDictionary(tokensForValue, ::parseFLong)
                            state[name] = dict
                        }
                    }
                }

                FLONG -> {
                    val long = parseFLong(typeValue)
                    state[name] = long
                }

                FDOUBLE -> {
                    val double = parseFDouble(typeValue)
                    state[name] = double
                }

                FSTRING -> {
                    val string = parseFString(typeValue)
                    state[name] = string
                }

                FBOOLEAN -> {
                    val boolean = parseFBoolean(typeValue)
                    state[name] = boolean
                }

                else -> {
                    println(a)
                }
            }
        }

        return state
    }

    private fun parseBaseAttributes(tokens: ParseTree): Triple<ViewAttributes, LayoutAttributes, TapAttributes> {
        val viewAttributes = ViewAttributes()
        val layoutAttributes = LayoutAttributes()
        val onTapList = mutableListOf<TapExpression>()
        val onLongTapList = mutableListOf<TapExpression>()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is LayoutAttrContext -> {
                    val tokensForNode = temp.getChild(0)
                    val attrToken = tokensForNode.getChild(0)
                    val tokensForValue = tokensForNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (attrToken.text) {
                        HEIGHT -> {
                            layoutAttributes.height = parseDimension(tokensForValue)
                        }

                        WIDTH -> {
                            layoutAttributes.width = parseDimension(tokensForValue)
                        }

                        WEIGHT -> {
                            layoutAttributes.weight = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                layoutAttributes.weight?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                layoutAttributes.weight?.value = parseFDouble(tokensForValue)
                            }
                        }

                        GRAVITY -> {
                            layoutAttributes.gravity = parseGravity(tokensForValue)
                        }

                        MARGIN -> {
                            layoutAttributes.margin = parseMarginPadding(tokensForNode)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + LAYOUT_ATTR)
                        }
                    }
                }

                is ViewAttrContext -> {
                    val tokensForNode = temp.getChild(0)
                    val attrToken = tokensForNode.getChild(0)
                    val tokensForValue = tokensForNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (attrToken.text) {
                        TEST_TAG -> {
                            viewAttributes.testTag = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                viewAttributes.testTag?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                viewAttributes.testTag?.value = parseFString(tokensForValue)
                            }
                        }

                        ALPHA -> {
                            viewAttributes.alpha = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                viewAttributes.alpha?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                viewAttributes.alpha?.value = parseFDouble(tokensForValue).toFloat()
                            }
                        }

                        PADDING -> {
                            viewAttributes.padding = parseMarginPadding(tokensForNode)
                        }

                        BACKGROUND -> {
                            viewAttributes.background = parseBackground(tokensForNode)
                        }

                        IS_ENABLED -> {
                            viewAttributes.isEnabled = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                viewAttributes.isEnabled?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                viewAttributes.isEnabled?.value = parseFBoolean(tokensForValue)
                            }
                        }

                        IS_VISIBLE -> {
                            viewAttributes.isVisible = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                viewAttributes.isVisible?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                viewAttributes.isVisible?.value = parseFBoolean(tokensForValue)
                            }
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + VIEW_ATTR)
                        }
                    }
                }

                is TapAttrContext -> {
                    val tokensForNode = temp.getChild(0)
                    val attrToken = tokensForNode.getChild(0)

                    when (attrToken.text) {
                        ON_TAP -> {
                            for (j in 0 until tokensForNode.childCount) {
                                val curToken = tokensForNode.getChild(j)

                                if (curToken is TapExpressionContext) {
                                    val variableName = curToken.getChild(0).text
                                    val expressionType = parseAttrExpression(curToken.getChild(2))
                                    val tapExpression = TapExpression(variableName, expressionType)
                                    onTapList.add(tapExpression)
                                }
                            }
                        }

                        ON_LONG_TAP -> {
                            for (j in 0 until tokensForNode.childCount) {
                                val curToken = tokensForNode.getChild(j)

                                if (curToken is TapExpressionContext) {
                                    val variableName = curToken.getChild(0).text
                                    val expressionType = parseAttrExpression(curToken.getChild(2))
                                    val tapExpression = TapExpression(variableName, expressionType)
                                    onLongTapList.add(tapExpression)
                                }
                            }
                        }
                    }
                }

                else -> {}
            }
        }

        val tapAttributes = TapAttributes(
            onTap = if (onTapList.isEmpty()) null else onTapList,
            onLongTap = if (onLongTapList.isEmpty()) null else onLongTapList,
        )

        return Triple(viewAttributes, layoutAttributes, tapAttributes)
    }

    private fun parseFlowRowAttributes(tokens: ParseTree): FlowRowAttributes {
        val flowRowAttributes = FlowRowAttributes()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is FlowRowAttrContext -> {
                    val attrToken = temp.getChild(0).getChild(0)
                    val tokensForValue = temp.getChild(0).getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (attrToken.text) {
                        MAX_LINES_COUNT -> {
                            flowRowAttributes.maxLinesCount = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                flowRowAttributes.maxLinesCount?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                flowRowAttributes.maxLinesCount?.value = parseFInt(tokensForValue)
                            }
                        }

                        HORIZONTAL_SPACING -> {
                            flowRowAttributes.horizontalSpacing =
                                parseDimensionExact(tokensForValue)
                        }

                        VERTICAL_SPACING -> {
                            flowRowAttributes.verticalSpacing = parseDimensionExact(tokensForValue)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + FLOW_ROW_ATTR)
                        }
                    }
                }

                else -> {}
            }
        }

        return flowRowAttributes
    }

    private fun parseTextAttributes(tokens: ParseTree): TextAttributes {
        val textAttributes = TextAttributes()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is TextAttrContext -> {
                    val tokensForParsingNode = temp.getChild(0)
                    val attrToken = tokensForParsingNode.getChild(0)
                    val tokensForValue = tokensForParsingNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (attrToken.text) {
                        TEXT -> {
                            textAttributes.text = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                textAttributes.text?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                textAttributes.text?.value = parseFString(tokensForValue)
                            }
                        }

                        TEXT_CONFIG -> {
                            textAttributes.config = parseConfig(tokensForParsingNode)
                        }

                        ALIGN -> {
                            textAttributes.align = parseAlign(tokensForValue)
                        }

                        OVERFLOW -> {
                            textAttributes.overflow = parseOverflow(tokensForValue)
                        }

                        MAX_LINES -> {
                            textAttributes.maxLines = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                textAttributes.maxLines?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                textAttributes.maxLines?.value = parseFInt(tokensForValue)
                            }
                        }

                        LINE_HEIGHT -> {
                            textAttributes.lineHeight = parseDimensionExact(tokensForValue)
                        }

                        LETTER_SPACING -> {
                            textAttributes.letterSpacing = parseDimensionExact(tokensForValue)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + TEXT_ATTR)
                        }
                    }
                }

                else -> {}
            }
        }

        return textAttributes
    }

    private fun parseImageAttributes(tokens: ParseTree): ImageAttributes {
        val imageAttributes = ImageAttributes()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is ImageAttrContext -> {
                    val attrToken = temp.getChild(0).getChild(0)
                    val tokensForValue = temp.getChild(0).getChild(2)
                    val tokensForColor = tokensForValue.getChild(2)

                    when (attrToken.text) {
                        SOURCE -> {
                            imageAttributes.source = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                imageAttributes.source?.expression =
                                    parseAttrExpression(tokensForValue.getChild(0))
                            } else {
                                imageAttributes.source?.value = parseFString(tokensForValue)
                            }
                        }

                        PLACEHOLDER -> {
                            imageAttributes.placeholder = ExpressionWithValue()

                            if (tokensForColor.payload is AttrExpressionContext) {
                                imageAttributes.placeholder?.expression =
                                    parseAttrExpression(tokensForColor.getChild(0))
                            } else {
                                imageAttributes.placeholder?.value = parseString(tokensForColor)
                            }
                        }

                        PLACEHOLDER_TINT -> {
                            imageAttributes.placeHolderTint = ExpressionWithValue()

                            if (tokensForColor.payload is AttrExpressionContext) {
                                imageAttributes.placeHolderTint?.expression =
                                    parseAttrExpression(tokensForColor.getChild(0))
                            } else {
                                imageAttributes.placeHolderTint?.value = parseString(tokensForColor)
                            }
                        }

                        TINT -> {
                            imageAttributes.tint = ExpressionWithValue()

                            if (tokensForColor.payload is AttrExpressionContext) {
                                imageAttributes.tint?.expression =
                                    parseAttrExpression(tokensForColor.getChild(0))
                            } else {
                                imageAttributes.tint?.value = parseString(tokensForColor)
                            }
                        }

                        RESIZE_MODE -> {
                            imageAttributes.resizeMode = parseResizeMode(tokensForValue)
                        }

                        ANIMATE_CHANGES -> {
                            imageAttributes.animateChanges = parseAnimateChanges(tokensForValue)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + IMAGE_ATTR)
                        }
                    }
                }

                else -> {}
            }
        }

        return imageAttributes
    }

    private fun parseTextFieldAttributes(tokens: ParseTree): TextFieldAttributes {
        val textFieldAttributes = TextFieldAttributes()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is TextFieldAttrContext -> {
                    val tokensForParsingNode = temp.getChild(0)
                    val attrToken = tokensForParsingNode.getChild(0)
                    val tokensForValue = tokensForParsingNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (attrToken.text) {
                        TEXT -> {
                            textFieldAttributes.text = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                textFieldAttributes.text?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                textFieldAttributes.text?.value = parseFString(tokensForValue)
                            }
                        }

                        CONFIG -> {
                            textFieldAttributes.config = parseConfig(tokensForParsingNode)
                        }

                        LINE_HEIGHT -> {
                            textFieldAttributes.lineHeight = parseDimensionExact(tokensForValue)
                        }

                        LETTER_SPACING -> {
                            textFieldAttributes.letterSpacing = parseDimensionExact(tokensForValue)
                        }

                        IS_MULTILINE -> {
                            textFieldAttributes.isMultiline = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                textFieldAttributes.isMultiline?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                textFieldAttributes.isMultiline?.value =
                                    parseFBoolean(tokensForValue)
                            }
                        }

                        KEYBOARD_OPTIONS -> {
                            textFieldAttributes.keyboardOptions =
                                parseKeyboardOptions(tokensForParsingNode)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + TEXT_FIELD_ATTR)
                        }
                    }
                }

                else -> {}
            }
        }

        return textFieldAttributes
    }

    private fun parseDimension(tokens: ParseTree): Dimension {
        val node = tokens.getChild(0)
        val leaf = node.getChild(0)

        return when (val text = leaf.text) {
            FILL -> return Dimension.Match.Fill
            WRAP -> return Dimension.Match.Wrap
            else -> {
                if (text.isNotEmpty() && text[0].isDigit()) {
                    return parseDimensionExact(node)
                } else {
                    Log.e(TAG, ILLEGAL_ARGUMENT + DIMENSION)
                    Dimension.Match.Wrap// return default value if parsing went wrong
                }
            }
        }
    }

    private fun parseFDouble(tokens: ParseTree): Double {
        var text = tokens.text
        text = text.substring(0, text.length - 2)
        return text.toDouble()
    }

    private fun parseGravity(tokens: ParseTree): Gravity {
        var enumValue: GravityEnum? = null

        if (tokens.childCount > 3) {
            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
            return Gravity(GravityEnum.LEFT_TOP)
        }

        when (tokens) {
            is GravityExpressionContext -> {
                for (i in 0 until tokens.childCount) {
                    when (val temp = tokens.getChild(i)) {
                        is GravityValueContext -> {
                            val value = temp.getChild(0).text.toGravityEnum()
                            enumValue = value
                        }

                        is GravityExpressionContext -> {
                            val expression = temp.getChild(0)
                            val value = expression.text.toGravityEnum()

                            if (expression !is GravityValueContext) {
                                Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                            }

                            when (enumValue) {
                                GravityEnum.LEFT -> {
                                    when (value) {
                                        GravityEnum.TOP -> {
                                            enumValue = GravityEnum.LEFT_TOP
                                        }

                                        GravityEnum.BOTTOM -> {
                                            enumValue = GravityEnum.LEFT_BOTTOM
                                        }

                                        GravityEnum.CENTER -> {
                                            enumValue = GravityEnum.LEFT_CENTER
                                        }

                                        else -> {
                                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                        }
                                    }
                                }

                                GravityEnum.RIGHT -> {
                                    when (value) {
                                        GravityEnum.TOP -> {
                                            enumValue = GravityEnum.RIGHT_TOP
                                        }

                                        GravityEnum.BOTTOM -> {
                                            enumValue = GravityEnum.RIGHT_BOTTOM
                                        }

                                        GravityEnum.CENTER -> {
                                            enumValue = GravityEnum.RIGHT_CENTER
                                        }

                                        else -> {
                                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                        }
                                    }
                                }

                                GravityEnum.TOP -> {
                                    when (value) {
                                        GravityEnum.LEFT -> {
                                            enumValue = GravityEnum.LEFT_TOP
                                        }

                                        GravityEnum.RIGHT -> {
                                            enumValue = GravityEnum.RIGHT_TOP
                                        }

                                        GravityEnum.CENTER -> {
                                            enumValue = GravityEnum.TOP_CENTER
                                        }

                                        else -> {
                                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                        }
                                    }
                                }

                                GravityEnum.BOTTOM -> {
                                    when (value) {
                                        GravityEnum.LEFT -> {
                                            enumValue = GravityEnum.LEFT_BOTTOM
                                        }

                                        GravityEnum.RIGHT -> {
                                            enumValue = GravityEnum.RIGHT_BOTTOM
                                        }

                                        GravityEnum.CENTER -> {
                                            enumValue = GravityEnum.BOTTOM_CENTER
                                        }

                                        else -> {
                                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                        }
                                    }
                                }

                                GravityEnum.CENTER -> {
                                    when (value) {
                                        GravityEnum.LEFT -> {
                                            enumValue = GravityEnum.LEFT_CENTER
                                        }

                                        GravityEnum.RIGHT -> {
                                            enumValue = GravityEnum.RIGHT_CENTER
                                        }

                                        GravityEnum.TOP -> {
                                            enumValue = GravityEnum.TOP_CENTER
                                        }

                                        GravityEnum.BOTTOM -> {
                                            enumValue = GravityEnum.BOTTOM_CENTER
                                        }

                                        else -> {
                                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                        }
                                    }
                                }

                                else -> {
                                    Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                                }
                            }
                        }

                        is TerminalNode -> when (temp.text) {
                            PLUS -> {}

                            else -> {
                                Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                            }
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                        }
                    }
                }
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
            }
        }

        return Gravity(enumValue ?: GravityEnum.LEFT_TOP)
    }

    private fun String.toGravityEnum(): GravityEnum {
        return when (this) {
            LEFT -> GravityEnum.LEFT
            RIGHT -> GravityEnum.RIGHT
            TOP -> GravityEnum.TOP
            BOTTOM -> GravityEnum.BOTTOM
            CENTER -> GravityEnum.CENTER

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + GRAVITY)
                GravityEnum.LEFT_TOP
            }
        }
    }

    private fun parseMarginPadding(tokens: ParseTree): Insets {
        val insets = Insets()

        for (i in 0 until tokens.childCount) {
            when (val temp = tokens.getChild(i)) {
                is InsetsContext -> {
                    val (name, value) = parseInsets(temp)

                    when (name) {
                        LEFT -> {
                            insets.left = insets.left ?: value
                        }

                        RIGHT -> {
                            insets.right = insets.right ?: value
                        }

                        TOP -> {
                            insets.top = insets.top ?: value
                        }

                        BOTTOM -> {
                            insets.bottom = insets.bottom ?: value
                        }

                        HORIZONTAL -> {
                            insets.left = insets.left ?: value
                            insets.right = insets.right ?: value
                        }

                        VERTICAL -> {
                            insets.top = insets.top ?: value
                            insets.bottom = insets.bottom ?: value
                        }

                        ALL -> {
                            insets.left = insets.left ?: value
                            insets.right = insets.right ?: value
                            insets.top = insets.top ?: value
                            insets.bottom = insets.bottom ?: value
                        }

                        else -> {
                            Log.d(TAG, ILLEGAL_ARGUMENT + PADDING_OR_MARGIN)
                        }
                    }
                }

                else -> {}
            }
        }

        return insets
    }

    private fun parseInsets(tokens: ParseTree): Pair<String, Dimension.Exact> {
        if (tokens.childCount != 4
            || tokens.getChild(0) !is InsetsNameContext
            || tokens.getChild(2) !is ExactContext
        ) {
            Log.e(TAG, ILLEGAL_ARGUMENT + PADDING_OR_MARGIN)
            return Pair("", Dimension.Exact.AdaptivePoints(0.0))
        }

        val insetName = tokens.getChild(0).text
        val exact = parseDimensionExact(tokens.getChild(2))

        return Pair(insetName, exact)
    }

    private fun parseString(tokens: ParseTree): String {
        var text = tokens.text
        if (text.startsWith("\"")) text = text.substring(1, text.length - 1)
        return text
    }

    private fun parseFString(tokens: ParseTree): String {
        var text = tokens.text
        text = text.substring(1, text.length - 3)
        return text
    }

    private fun parseBackground(tokens: ParseTree): Background {
        val background = Background()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is BackgroundValueContext -> {
                    when (val tokensForParsingNode = temp.getChild(0)) {
                        is BorderContext -> {
                            background.border = parseBorder(tokensForParsingNode)
                        }

                        is CornersRadiusContext -> {
                            background.cornerRadius = parseCornersRadius(tokensForParsingNode)
                        }

                        is ColorContext -> {
                            val tokensForValue = tokensForParsingNode.getChild(2)
                            val tokensForColor = tokensForValue.getChild(2)
                            val tokensForExpression = tokensForColor.getChild(0)

                            background.color = ExpressionWithValue()

                            if (tokensForColor.payload is AttrExpressionContext) {
                                background.color?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                background.color?.value = parseString(tokensForColor)
                            }
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + BACKGROUND)
                        }
                    }
                }

                else -> {}
            }
        }

        return background
    }

    private fun parseBorder(tokens: ParseTree): Border {
        val border = Border()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is BorderAttrContext -> {
                    val tokensForParsingNode = temp.getChild(0)
                    val tokensForValue = tokensForParsingNode.getChild(2)
                    val tokensForColor = tokensForValue.getChild(2)
                    val tokensForExpression = tokensForColor.getChild(0)

                    when (tokensForParsingNode) {
                        is WidthExactContext -> {
                            border.width = parseDimensionExact(tokensForValue)
                        }

                        is ColorContext -> {
                            border.color = ExpressionWithValue()

                            if (tokensForColor.payload is AttrExpressionContext) {
                                border.color?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                border.color?.value = parseString(tokensForColor)
                            }
                        }

                        is DashSizeContext -> {
                            border.dashSize = parseDimensionExact(tokensForValue)
                        }

                        is DashGapContext -> {
                            border.dashGap = parseDimensionExact(tokensForValue)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + BORDER)
                        }
                    }
                }

                is Token -> {}

                else -> {
                    Log.e(TAG, ILLEGAL_ARGUMENT + BORDER)
                }
            }
        }

        return border
    }

    private fun parseCornersRadius(tokens: ParseTree): CornersRadius {
        val cornersRadius = CornersRadius()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is CornersContext -> {
                    val tokensForName = temp.getChild(0)
                    val tokensForValue = temp.getChild(2)

                    if (tokensForValue !is ExactContext || tokensForName !is CornerNameContext) {
                        Log.e(TAG, ILLEGAL_ARGUMENT + CORNERS_RADIUS)
                        continue
                    }

                    val exact = parseDimensionExact(tokensForValue)
                    val name = parseString(tokensForName.getChild(0))

                    when (name) {
                        LEFT_TOP -> {
                            cornersRadius.leftTop = exact
                        }

                        RIGHT_TOP -> {
                            cornersRadius.rightTop = exact
                        }

                        LEFT_BOTTOM -> {
                            cornersRadius.leftBottom = exact
                        }

                        RIGHT_BOTTOM -> {
                            cornersRadius.rightBottom = exact
                        }

                        ALL -> {
                            cornersRadius.leftTop = exact
                            cornersRadius.rightTop = exact
                            cornersRadius.leftBottom = exact
                            cornersRadius.rightBottom = exact
                        }
                    }
                }

                is Token -> {}

                else -> {
                    Log.e(TAG, ILLEGAL_ARGUMENT + CORNERS_RADIUS)
                }
            }
        }

        return cornersRadius
    }

    private fun parseBoolean(tokens: ParseTree): Boolean {
        return tokens.text.toBoolean()
    }

    private fun parseFBoolean(tokens: ParseTree): Boolean {
        val text = parseFType(tokens)
        return text.toBoolean()
    }

    private fun parseResizeMode(tokens: ParseTree): ResizeMode {
        return when (tokens.text) {
            ASPECT_FIT -> {
                ResizeMode.ASPECT_FIT
            }

            SCALE_TO_FILL -> {
                ResizeMode.SCALE_TO_FILL
            }

            ASPECT_FILL -> {
                ResizeMode.ASPECT_FILL
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + RESIZE_MODE)
                ResizeMode.ASPECT_FIT // return default value if parsing went wrong
            }
        }
    }

    private fun parseAnimateChanges(tokens: ParseTree): AnimateChanges {
        return when (tokens.text) {
            NONE -> {
                return AnimateChanges.NONE
            }

            CROSS_FADE -> {
                return AnimateChanges.CROSS_FADE
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + ANIMATE_CHANGES)
                AnimateChanges.NONE // return default value if parsing went wrong
            }
        }
    }

    private fun parseAlign(tokens: ParseTree): Align {
        return when (tokens.text) {
            CENTER -> {
                Align.CENTER
            }

            START -> {
                Align.START
            }

            END -> {
                Align.END
            }

            JUSTIFY -> {
                Align.JUSTIFY
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + ALIGN)
                Align.JUSTIFY // return default value if parsing went wrong
            }
        }
    }

    private fun parseDimensionExact(tokens: ParseTree): Dimension.Exact {
        val double = tokens.getChild(0).text
        val points = tokens.getChild(2).text

        return when (points) {
            NP -> {
                Dimension.Exact.NativePoints(double.toDouble())
            }

            AP -> {
                Dimension.Exact.AdaptivePoints(double.toDouble())
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + DIMENSION)
                Dimension.Exact.NativePoints(0.0) // return default value if parsing went wrong
            }
        }
    }

    private fun parseOverflow(tokens: ParseTree): Overflow {
        return when (tokens.text) {
            ELLIPSIS -> {
                Overflow.ELLIPSIS
            }

            CLIP -> {
                Overflow.CLIP
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + OVERFLOW)
                Overflow.CLIP // return default value if parsing went wrong
            }
        }
    }

    private fun parseFInt(tokens: ParseTree): Int {
        val text = parseFType(tokens)
        return text.toInt()
    }

    private fun parseFType(tokens: ParseTree): String {
        var text = tokens.text
        text = text.substring(0, text.length - 2)
        return text
    }

    private fun parseFLong(tokens: ParseTree): Long {
        val text = parseFType(tokens)
        return text.toLong()
    }

    private fun parseConfig(tokens: ParseTree): Config {
        val config = Config()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is ConfigAttrContext -> {
                    val tokensForParsingNode = temp.getChild(0)
                    val tokensForValue = tokensForParsingNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (tokensForParsingNode) {
                        is FontSizeContext -> {
                            config.fontSize = parseDimensionExact(tokensForValue)
                        }

                        is FontStyleContext -> {
                            config.fontStyle = parseFontStyle(tokensForValue)
                        }

                        is ColorContext -> {
                            config.color =
                                parseString(tokensForValue.getChild(2))
                        }

                        is IsUnderlineContext -> {
                            config.isUnderline = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                config.isUnderline?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                config.isUnderline?.value = parseFBoolean(tokensForValue)
                            }
                        }

                        is IsStrikeThroughContext -> {
                            config.isStrikeThrough = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                config.isStrikeThrough?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                config.isStrikeThrough?.value = parseFBoolean(tokensForValue)
                            }
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + TEXT_CONFIG)
                        }
                    }
                }

                else -> {}
            }
        }

        return config
    }

    private fun parseFontStyle(tokens: ParseTree): FontStyle {
        return when (tokens.text) {
            REGULAR -> {
                FontStyle.Regular
            }

            BOLD -> {
                FontStyle.Bold
            }

            BOLD_ITALIC -> {
                FontStyle.BoldItalic
            }

            EXTRA_BOLD_ITALIC -> {
                FontStyle.ExtraBoldItalic
            }

            SEMI_BOLD -> {
                FontStyle.SemiBold
            }

            MEDIUM -> {
                FontStyle.Medium
            }

            ALI_BOLD -> {
                FontStyle.AliBold
            }

            ALI_REGULAR -> {
                FontStyle.AliRegular
            }

            ALI_LIGHT -> {
                FontStyle.AliLight
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + FONT_STYLE)
                FontStyle.Regular // return default value if parsing went wrong
            }
        }
    }

    private fun parseKeyboardOptions(tokens: ParseTree): KeyboardOptions {
        val keyboardOptions = KeyboardOptions()

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (temp.payload) {
                is KeyboardOptionsContext -> {
                    val tokensForParsingNode = temp.getChild(0)
                    val tokensForValue = tokensForParsingNode.getChild(2)
                    val tokensForExpression = tokensForValue.getChild(0)

                    when (tokensForParsingNode) {
                        is CapitalizationContext -> {
                            keyboardOptions.capitalization = parseCapitalization(tokensForValue)
                        }

                        is AutoCorrectContext -> {
                            keyboardOptions.autoCorrect = ExpressionWithValue()

                            if (tokensForValue.payload is AttrExpressionContext) {
                                keyboardOptions.autoCorrect?.expression =
                                    parseAttrExpression(tokensForExpression)
                            } else {
                                keyboardOptions.autoCorrect?.value = parseFBoolean(tokensForValue)
                            }
                        }

                        is KeyboardTypeContext -> {
                            keyboardOptions.keyboardType = parseKeyboardType(tokensForValue)
                        }

                        is ImeActionContext -> {
                            keyboardOptions.imeAction = parseIme(tokensForValue)
                        }

                        is InputAccessoryActionContext -> {
                            keyboardOptions.inputAccessoryAction = parseIme(tokensForValue)
                        }

                        else -> {
                            Log.e(TAG, ILLEGAL_ARGUMENT + TEXT_CONFIG)
                        }
                    }
                }

                else -> {}
            }
        }

        return keyboardOptions
    }

    private fun parseCapitalization(tokens: ParseTree): KeyboardCapitalization {
        return when (tokens.text) {
            NONE -> {
                KeyboardCapitalization.NONE
            }

            CHARACTERS -> {
                KeyboardCapitalization.CHARACTERS
            }

            WORDS -> {
                KeyboardCapitalization.WORDS
            }

            SENTENCES -> {
                KeyboardCapitalization.SENTENCES
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + CAPITALIZATION)
                KeyboardCapitalization.NONE // return default value if parsing went wrong
            }
        }
    }

    private fun parseKeyboardType(tokens: ParseTree): KeyboardType {
        return when (tokens.text) {
            TEXT -> {
                KeyboardType.TEXT
            }

            ASCII -> {
                KeyboardType.ASCII
            }

            NUMBER -> {
                KeyboardType.NUMBER
            }

            PHONE -> {
                KeyboardType.PHONE
            }

            URI -> {
                KeyboardType.URI
            }

            EMAIL -> {
                KeyboardType.EMAIL
            }

            PASSWORD -> {
                KeyboardType.PASSWORD
            }

            NUMBER_PASSWORD -> {
                KeyboardType.NUMBER_PASSWORD
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + KEYBOARD_TYPE)
                KeyboardType.TEXT // return default value if parsing went wrong
            }
        }
    }

    private fun parseIme(tokens: ParseTree): ImeAction {
        return when (tokens.text) {
            DEFAULT -> {
                ImeAction.DEFAULT
            }

            NONE -> {
                ImeAction.NONE
            }

            GO -> {
                ImeAction.GO
            }

            SEARCH -> {
                ImeAction.SEARCH
            }

            SEND -> {
                ImeAction.SEND
            }

            PREVIOUS -> {
                ImeAction.PREVIOUS
            }

            NEXT -> {
                ImeAction.NEXT
            }

            DONE -> {
                ImeAction.DONE
            }

            else -> {
                Log.e(TAG, ILLEGAL_ARGUMENT + IME)
                ImeAction.DEFAULT // return default value if parsing went wrong
            }
        }
    }

    private fun <T : Any> parseArray(
        tokens: ParseTree,
        cast: (ParseTree) -> T
    ): FList<T> {
        val list = FList<T>()

        for (i in 0 until tokens.childCount) {
            if (i % 2 == 1) continue
            val temp = tokens.getChild(i)
            list.add(cast(temp))
        }

        return list
    }

    private fun <T : Any> parseDictionary(
        tokens: ParseTree,
        cast: (ParseTree) -> T
    ): FMap<T> {
        val map = FMap<T>()
        var key = ""

        for (i in 0 until tokens.childCount) {
            val temp = tokens.getChild(i)

            when (i % 4) {
                0 -> {
                    key = parseFString(temp)
                }

                1, 3 -> continue

                2 -> {
                    map[key] = cast(temp)
                }
            }
        }

        return map
    }

    private fun parseAttrExpression(tokens: ParseTree): AttrExpressionType {
        return when (tokens.payload) {
            is IfExprContext -> {
                parseIfThen(tokens)
            }

            is FieldExprContext -> {
                parseFieldExpr(tokens)
            }

            else -> {
                throw IllegalArgumentException(ILLEGAL_ARGUMENT + ATTR_EXPR)
            }
        }
    }

    private fun parseFieldExpr(tokens: ParseTree): AttrExpressionType.FieldExpr {
        val name = tokens.getChild(0).text
        val get = tokens.getChild(2)

        return when (val payload = get?.payload) {
            null -> AttrExpressionType.FieldExpr(name = name)

            is CommonToken -> {
                val text = get.text

                when (DSLGrammarLexer.VOCABULARY.getDisplayName(payload.type)) {
                    LONG -> {
                        val value = text.toInt()
                        AttrExpressionType.FieldExpr(name, GetExpression.IntGet(value))
                    }

                    STRING -> {
                        val value = text.substring(1, text.length - 1)
                        AttrExpressionType.FieldExpr(name, GetExpression.StringGet(value))
                    }

                    else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + FIELD_EXPR)
                }
            }

            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + FIELD_EXPR)
        }
    }

    private fun parseIfThen(tokens: ParseTree): AttrExpressionType.IfThen {
        val conditionToken = tokens.getChild(2)
        val ifValuesToken = tokens.getChild(4)

        return when (conditionToken.payload) {
            is ConditionContext -> {
                val const = parseConst(conditionToken.getChild(0).getChild(0))

                val equal = if (conditionToken.getChild(1) != null) {
                    conditionToken.getChild(1).text.equals(EQUAL)
                } else {
                    null
                }

                val field = if (conditionToken.getChild(2) != null) {
                    parseFieldExpr(conditionToken.getChild(2))
                } else {
                    null
                }

                val condition = Condition(const, equal, field)
                val pairIfValues = parseIfValues(ifValuesToken)

                AttrExpressionType.IfThen(condition, pairIfValues.first, pairIfValues.second)
            }

            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + IF_THEN)
        }
    }

    private fun parseConst(tokens: ParseTree): Const {
        val token = tokens.payload as? CommonToken ?: throw IllegalArgumentException(
            ILLEGAL_ARGUMENT + CONSTS
        )

        return when (DSLGrammarLexer.VOCABULARY.getDisplayName(token.type)) {
            FBOOLEAN -> {
                Const.BooleanConst(parseFBoolean(tokens))
            }

            FLONG -> {
                Const.IntConst(parseFInt(tokens))
            }

            FDOUBLE -> {
                Const.DoubleConst(parseFDouble(tokens))
            }

            FSTRING -> {
                Const.StringConst(parseFString(tokens))
            }

            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + CONSTS)
        }
    }

    private fun parseIfValues(tokens: ParseTree): Pair<ValueExpression, ValueExpression?> {
        val first = tokens.getChild(0)
        val second = tokens.getChild(2)

        val trueValue: ValueExpression = when (first.payload) {
            is ConstsContext -> {
                parseConst(first.getChild(0))

            }

            is FieldExprContext -> {
                parseFieldExpr(first)
            }

            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + IF_VALUES)
        }

        val falseValue: ValueExpression? = when (second?.payload) {
            null -> null

            is ConstsContext -> {
                parseConst(second.getChild(0))
            }

            is FieldExprContext -> {
                parseFieldExpr(second)
            }

            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT + IF_VALUES)
        }

        return trueValue to falseValue
    }

    private const val TAG = "DSL Parser"
    private const val PADDING_OR_MARGIN = "padding or margin"
    private const val LAYOUT_ATTR = "layout attributes"
    private const val ILLEGAL_ARGUMENT = "Illegal argument in "
    private const val VIEW_ATTR = "view attributes"
    private const val TEXT_ATTR = "Text attributes"
    private const val IMAGE_ATTR = "Image attributes"
    private const val TEXT_FIELD_ATTR = "TextField attributes"
    private const val FLOW_ROW_ATTR = "FlowRow attributes"
    private const val CORNERS_RADIUS = "cornersRadius"
    private const val FONT_STYLE = "FontStyle"
    private const val CAPITALIZATION = "Capitalization"
    private const val KEYBOARD_TYPE = "KeyboardType"
    private const val IME = "ime"
    private const val ATTR_EXPR = "attrExpr"
    private const val FIELD_EXPR = "fieldExpr"
    private const val IF_THEN = "ifThen"
    private const val CONSTS = "Consts"
    private const val IF_VALUES = "ifValues"
    private const val FIELDS = "fields"

    private const val HEIGHT = "height"
    private const val WIDTH = "width"
    private const val WEIGHT = "weight"
    private const val GRAVITY = "gravity"
    private const val MARGIN = "margin"

    private const val TEST_TAG = "testTag"
    private const val ALPHA = "alpha"
    private const val PADDING = "padding"
    private const val BACKGROUND = "background"
    private const val IS_ENABLED = "isEnabled"
    private const val IS_VISIBLE = "isVisible"

    private const val SOURCE = "source"
    private const val PLACEHOLDER = "placeholder"
    private const val PLACEHOLDER_TINT = "placeholderTint"
    private const val TINT = "tint"
    private const val RESIZE_MODE = "resizeMode"
    private const val ANIMATE_CHANGES = "animateChanges"

    private const val TEXT = "text"
    private const val TEXT_CONFIG = "textConfig"
    private const val CONFIG = "config"
    private const val ALIGN = "align"
    private const val OVERFLOW = "overflow"
    private const val MAX_LINES = "maxLines"
    private const val LINE_HEIGHT = "lineHeight"
    private const val LETTER_SPACING = "letterSpacing"
    private const val IS_MULTILINE = "isMultiline"
    private const val KEYBOARD_OPTIONS = "keyboardOptions"

    private const val MAX_LINES_COUNT = "maxLinesCount"

    private const val VERTICAL_SPACING = "verticalSpacing"

    private const val HORIZONTAL_SPACING = "horizontalSpacing"

    private const val DIMENSION = "dimension"

    private const val FILL = "fill"
    private const val WRAP = "wrap"
    private const val NP = "np"
    private const val AP = "ap"

    private const val LEFT = "left"
    private const val RIGHT = "right"
    private const val TOP = "top"
    private const val BOTTOM = "bottom"
    private const val HORIZONTAL = "horizontal"
    private const val VERTICAL = "vertical"
    private const val ALL = "all"

    private const val BORDER = "border"

    private const val RIGHT_TOP = "rightTop"
    private const val LEFT_TOP = "leftTop"
    private const val LEFT_BOTTOM = "leftBottom"
    private const val RIGHT_BOTTOM = "rightBottom"

    private const val ASPECT_FIT = "aspectFit"
    private const val SCALE_TO_FILL = "scaleToFill"
    private const val ASPECT_FILL = "aspectFill"

    private const val NONE = "none"
    private const val CROSS_FADE = "crossFade"

    private const val CENTER = "center"
    private const val START = "start"
    private const val END = "end"
    private const val JUSTIFY = "justify"

    private const val ELLIPSIS = "ellipsis"
    private const val CLIP = "clip"

    private const val REGULAR = "regular"
    private const val BOLD = "bold"
    private const val BOLD_ITALIC = "boldItalic"
    private const val EXTRA_BOLD_ITALIC = "extraBoldItalic"
    private const val SEMI_BOLD = "semiBold"
    private const val MEDIUM = "medium"
    private const val ALI_BOLD = "aliBold"
    private const val ALI_REGULAR = "aliRegular"
    private const val ALI_LIGHT = "aliLight"

    private const val CHARACTERS = "characters"
    private const val WORDS = "words"
    private const val SENTENCES = "sentences"

    private const val ASCII = "ascii"
    private const val NUMBER = "number"
    private const val PHONE = "phone"
    private const val URI = "uri"
    private const val EMAIL = "email"
    private const val PASSWORD = "password"
    private const val NUMBER_PASSWORD = "numberPassword"

    private const val DEFAULT = "default"
    private const val GO = "go"
    private const val SEARCH = "search"
    private const val SEND = "send"
    private const val PREVIOUS = "previous"
    private const val NEXT = "next"
    private const val DONE = "done"

    private const val PLUS = "+"

    private const val ARRAY = "'Array'"
    private const val DICTIONARY = "'Dictionary'"
    private const val LONG = "LONG"
    private const val DOUBLE = "DOUBLE"
    private const val STRING = "STRING"
    private const val BOOLEAN = "BOOLEAN"

    private const val FBOOLEAN = "FBOOLEAN"
    private const val FSTRING = "FSTRING"
    private const val FLONG = "FLONG"
    private const val FDOUBLE = "FDOUBLE"

    private const val EQUAL = "=="

    private const val ON_TAP = "onTap"
    private const val ON_LONG_TAP = "onLongTap"
}