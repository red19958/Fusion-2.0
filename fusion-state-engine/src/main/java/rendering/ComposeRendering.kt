package rendering

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.Placeholder
import com.bumptech.glide.integration.compose.placeholder
import com.fusion.state.R
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
import nodes.layout.lazy.LazyListNode
import nodes.layout.lazy.Parts.Item
import nodes.layout.lazy.Parts.Items
import util.State
import types.Align
import types.AnimateChanges
import types.Dimension
import types.FontStyle
import types.GravityEnum
import types.ImeAction
import types.KeyboardCapitalization
import types.KeyboardOptions
import types.KeyboardType
import androidx.compose.ui.text.input.KeyboardCapitalization as ComposeCapitalization
import androidx.compose.foundation.text.KeyboardOptions as ComposeKeyboardOptions
import androidx.compose.ui.text.input.KeyboardType as ComposeKeyboardType
import androidx.compose.ui.text.input.ImeAction as ComposeImeAction
import types.Overflow
import types.ResizeMode
import types.expressions.AttrExpressionType
import types.expressions.Const
import types.expressions.ExpressionWithValue
import types.expressions.GetExpression
import types.expressions.TapExpression
import util.FList
import util.FMap

typealias ParentModification = (Node) -> Modifier

object ComposeRendering {

    @Composable
    fun StartRender(pair: Pair<Node, State>) {
        Render(node = pair.first, remember { mutableStateOf(pair.second) })
    }

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)
    @Composable
    private fun Render(
        node: Node,
        realState: MutableState<State>,
        ignoreHeight: Boolean = false,
        ignoreWidth: Boolean = false,
        parenModification: ParentModification? = null,
    ) {
        val isVisible = node.viewAttributes.isVisible
        val isVisibleValue = if (isVisible?.value != null) {
            isVisible.value!!
        } else if (isVisible?.expression != null) {
            getAttrFromExpression(
                isVisible.expression!!,
                realState = realState
            )
        } else {
            true
        }

        if (!isVisibleValue) return

        var modifier = parenModification?.let { it(node) } ?: Modifier
        modifier = modifier.renderBaseAttr(
            node = node,
            realState = realState,
            ignoreHeight = ignoreHeight,
            ignoreWidth = ignoreWidth,
        )

        when (node) {
            is LayoutNode -> {
                RenderLayoutNode(
                    node = node,
                    realState = realState,
                    ignoreHeight = ignoreHeight,
                    ignoreWidth = ignoreWidth,
                    parenModification = parenModification,
                )
            }

            is LazyListNode -> {
                RenderLazyLayoutNode(
                    node = node,
                    realState = realState,
                    ignoreHeight = ignoreHeight,
                    ignoreWidth = ignoreWidth,
                    parenModification = parenModification,
                )
            }

            is TextNode -> {
                val colorInt = node.textAttributes.config?.color?.toColorInt()
                val color = if (colorInt == null) Color.Unspecified else Color(colorInt)

                val isUnderline = node.textAttributes.config?.isUnderline
                val isUnderlineValue = if (isUnderline?.value != null) {
                    isUnderline.value!!
                } else if (isUnderline?.expression != null) {
                    getAttrFromExpression(
                        isUnderline.expression!!,
                        realState = realState
                    )
                } else {
                    false
                }

                val isStrikeThrough = node.textAttributes.config?.isStrikeThrough
                val isStrikeThroughValue = if (isStrikeThrough?.value != null) {
                    isStrikeThrough.value!!
                } else if (isStrikeThrough?.expression != null) {
                    getAttrFromExpression(
                        isStrikeThrough.expression!!,
                        realState = realState
                    )
                } else {
                    false
                }

                val decoration = when (isUnderlineValue) {
                    true -> TextDecoration.Underline
                    else -> TextDecoration.None
                } + when (isStrikeThroughValue) {
                    true -> TextDecoration.LineThrough
                    else -> TextDecoration.None
                }

                val text = node.textAttributes.text
                val textValue = if (text?.value != null) {
                    text.value!!
                } else if (text?.expression != null) {
                    getAttrFromExpression(
                        text.expression!!,
                        realState = realState
                    )
                } else {
                    ""
                }

                val maxLines = node.textAttributes.maxLines
                val maxLinesValue = if (maxLines?.value != null) {
                    maxLines.value!!
                } else if (maxLines?.expression != null) {
                    getAttrFromExpression(
                        maxLines.expression!!,
                        realState = realState
                    )
                } else {
                    Int.MAX_VALUE
                }

                Text(
                    text = textValue,
                    modifier = modifier
                        .wrapContentHeight(Alignment.CenterVertically),
                    color = color,
                    fontSize = node.textAttributes.config?.fontSize?.toSp() ?: 16.sp,
                    fontFamily = node.textAttributes.config?.fontStyle.toFontFamily(),
                    letterSpacing = node.textAttributes.letterSpacing.toSp(),
                    textDecoration = decoration,
                    textAlign = node.textAttributes.align?.toTextAlign() ?: TextAlign.Start,
                    lineHeight = node.textAttributes.lineHeight?.toSp() ?: TextUnit.Unspecified,
                    overflow = node.textAttributes.overflow?.toTextOverflow() ?: TextOverflow.Clip,
                    maxLines = maxLinesValue,
                )
            }

            is TextFieldNode -> {
                val text = node.textFieldAttributes.text

                val textValue = if (text?.value != null) {
                    text.value!!
                } else if (text?.expression != null) {
                    getAttrFromExpression(
                        text.expression!!,
                        realState = realState
                    )
                } else {
                    ""
                }

                var textRemember by remember { mutableStateOf(textValue) }
                val colorInt = node.textFieldAttributes.config?.color?.toColorInt()
                val color = if (colorInt == null) Color.Unspecified else Color(colorInt)

                val isUnderline = node.textFieldAttributes.config?.isUnderline
                val isUnderlineValue = if (isUnderline?.value != null) {
                    isUnderline.value!!
                } else if (isUnderline?.expression != null) {
                    getAttrFromExpression(
                        isUnderline.expression!!,
                        realState = realState
                    )
                } else {
                    false
                }

                val isStrikeThrough = node.textFieldAttributes.config?.isStrikeThrough
                val isStrikeThroughValue = if (isStrikeThrough?.value != null) {
                    isStrikeThrough.value!!
                } else if (isStrikeThrough?.expression != null) {
                    getAttrFromExpression(
                        isStrikeThrough.expression!!,
                        realState = realState
                    )
                } else {
                    false
                }

                val decoration = when (isUnderlineValue) {
                    true -> TextDecoration.Underline
                    else -> TextDecoration.None
                } + when (isStrikeThroughValue) {
                    true -> TextDecoration.LineThrough
                    else -> TextDecoration.None
                }

                val keyboardOptions =
                    createKeyboardOptions(node.textFieldAttributes.keyboardOptions, realState)

                val isEnabled = node.viewAttributes.isEnabled
                val isEnabledValue = if (isEnabled?.value != null) {
                    isEnabled.value!!
                } else if (isEnabled?.expression != null) {
                    getAttrFromExpression(
                        isEnabled.expression!!,
                        realState = realState
                    )
                } else {
                    true
                }

                val isMultiline = node.textFieldAttributes.isMultiline
                val isMultilineValue = if (isMultiline?.value != null) {
                    isMultiline.value!!
                } else if (isMultiline?.expression != null) {
                    getAttrFromExpression(
                        isMultiline.expression!!,
                        realState = realState
                    )
                } else {
                    true
                }

                BasicTextField(
                    value = TextFieldValue(
                        text = textRemember,
                        selection = TextRange(textRemember.length)
                    ),
                    onValueChange = { value -> textRemember = value.text },
                    modifier = modifier
                        .wrapContentHeight(Alignment.CenterVertically),
                    enabled = isEnabledValue,
                    keyboardOptions = keyboardOptions,
                    textStyle = TextStyle(
                        color = color,
                        letterSpacing = node.textFieldAttributes.letterSpacing.toSp(),
                        textDecoration = decoration,
                        lineHeight = node.textFieldAttributes.lineHeight?.toSp()
                            ?: TextUnit.Unspecified,
                    ),
                    singleLine = !isMultilineValue,
                )
            }

            is ImageNode -> {
                val placeholder = createGlidePlaceholder(
                    node.imageAttributes.placeholder,
                    node.imageAttributes.placeHolderTint,
                    node.imageAttributes.tint,
                    realState,
                )

                val transition = when (node.imageAttributes.animateChanges) {
                    AnimateChanges.CROSS_FADE -> CrossFade
                    else -> null
                }

                val source = node.imageAttributes.source
                val sourceValue = if (source?.value != null) {
                    source.value!!
                } else if (source?.expression != null) {
                    getAttrFromExpression(
                        source.expression!!,
                        realState = realState
                    )
                } else {
                    ""
                }
                val tint = node.imageAttributes.tint
                val tintValue = if (tint?.value != null) {
                    tint.value!!
                } else if (tint?.expression != null) {
                    getAttrFromExpression<String>(
                        tint.expression!!,
                        realState = realState
                    )
                } else {
                    null
                }


                GlideImage(
                    modifier = modifier,
                    model = sourceValue,
                    contentDescription = null,
                    contentScale = node.imageAttributes.resizeMode.toContentScale(),
                    loading = placeholder,
                    failure = placeholder,
                    colorFilter = tintValue?.let {
                        ColorFilter.tint(Color(it.toColorInt()))
                    },
                    transition = transition,
                )
            }
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun RenderLayoutNode(
        node: LayoutNode,
        realState: MutableState<State>,
        ignoreHeight: Boolean = false,
        ignoreWidth: Boolean = false,
        parenModification: ParentModification? = null
    ) {
        val isVisible = node.viewAttributes.isVisible
        val isVisibleValue = if (isVisible?.value != null) {
            isVisible.value!!
        } else if (isVisible?.expression != null) {
            getAttrFromExpression(
                isVisible.expression!!,
                realState = realState
            )
        } else {
            true
        }

        if (!isVisibleValue) return

        var modifier = parenModification?.let { it(node) } ?: Modifier
        modifier = modifier.renderBaseAttr(
            node = node,
            realState = realState,
            ignoreHeight = ignoreHeight,
            ignoreWidth = ignoreWidth
        )

        when (node) {
            is BoxNode -> {
                Box(modifier) {
                    for (child in node.children) {
                        Render(node = child, realState = realState) { value ->
                            gravity(value)
                        }
                    }
                }
            }

            is ColumnNode -> {
                Column(modifier) {
                    for (child in node.children) {
                        Render(node = child, realState = realState, ignoreHeight = true) { value ->
                            weight(value, realState).then(gravity(value))
                        }
                    }
                }
            }

            is RowNode -> {
                Row(modifier) {
                    for (child in node.children) {
                        Render(node = child, realState = realState, ignoreWidth = true) { value ->
                            weight(value, realState).then(gravity(value))
                        }
                    }
                }
            }

            is FlowRowNode -> {
                FlowRow(
                    modifier = modifier,
                    horizontalArrangement = Arrangement.spacedBy(node.flowRowAttributes.horizontalSpacing.toDp()),
                    verticalArrangement = Arrangement.spacedBy(node.flowRowAttributes.verticalSpacing.toDp()),
                ) {
                    for (child in node.children) {
                        Render(node = child, realState = realState)
                    }
                }
            }


        }
    }

    @Composable
    private fun RenderLazyLayoutNode(
        node: LazyListNode,
        realState: MutableState<State>,
        ignoreHeight: Boolean = false,
        ignoreWidth: Boolean = false,
        parenModification: ParentModification? = null
    ) {
        val isVisible = node.viewAttributes.isVisible
        val isVisibleValue = if (isVisible?.value != null) {
            isVisible.value!!
        } else if (isVisible?.expression != null) {
            getAttrFromExpression(
                isVisible.expression!!,
                realState = realState
            )
        } else {
            true
        }

        if (!isVisibleValue) return

        var modifier = parenModification?.let { it(node) } ?: Modifier
        modifier = modifier.renderBaseAttr(
            node = node,
            realState = realState,
            ignoreHeight = ignoreHeight,
            ignoreWidth = ignoreWidth
        )

        when (node) {
            is LazyColumnNode -> {
                LazyColumn(modifier) {
                    for (child in node.children) {
                        when (child) {
                            is Item -> {
                                item {
                                    Render(node = child.child, realState = realState)
                                }
                            }

                            is Items -> {
                                val size = if (child.size.value != null) {
                                    child.size.value!!
                                } else if (child.size.expression != null) {
                                    getAttrFromExpression<Int>(child.size.expression!!, realState)
                                } else {
                                    throw IllegalArgumentException()
                                }

                                items(size) {
                                    Render(node = child.child, realState = realState)
                                }
                            }
                        }
                    }
                }
            }

            is LazyRowNode -> {
                LazyRow(modifier) {
                    for (child in node.children) {
                        when (child) {
                            is Item -> {
                                item {
                                    Render(node = child.child, realState = realState)
                                }
                            }

                            is Items -> {
                                val size = if (child.size.value != null) {
                                    child.size.value!!
                                } else if (child.size.expression != null) {
                                    getAttrFromExpression<Int>(child.size.expression!!, realState)
                                } else {
                                    throw IllegalArgumentException()
                                }

                                items(size) {
                                    Render(node = child.child, realState = realState)
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * Provide weights for children in [ColumnScope].
     */
    @SuppressLint("ModifierFactoryExtensionFunction")
    private fun ColumnScope.weight(node: Node, realState: MutableState<State>): Modifier {
        var result: Modifier = Modifier
        val weight = node.layoutAttributes.weight

        if (weight != null) {
            result = result.weight(
                weight.value?.toFloat() ?: getAttrFromExpression<Double>(
                    weight.expression!!,
                    realState = realState
                ).toFloat()
            )
        }

        return result
    }

    /**
     * Provide weights for children in [RowScope].
     */
    @SuppressLint("ModifierFactoryExtensionFunction")
    private fun RowScope.weight(node: Node, realState: MutableState<State>): Modifier {
        var result: Modifier = Modifier
        val weight = node.layoutAttributes.weight

        if (weight != null) {
            result = result.weight(
                weight.value?.toFloat() ?: getAttrFromExpression<Double>(
                    weight.expression!!,
                    realState = realState
                ).toFloat()
            )
        }

        return result
    }

    @SuppressLint("ModifierFactoryExtensionFunction")
    private fun ColumnScope.gravity(node: Node): Modifier {
        var result: Modifier = Modifier
        val gravity = node.layoutAttributes.gravity ?: return result

        result = when (gravity.value) {
            GravityEnum.LEFT,
            GravityEnum.LEFT_TOP,
            GravityEnum.LEFT_BOTTOM,
            GravityEnum.LEFT_CENTER -> {
                result.align(Alignment.Start)
            }

            GravityEnum.RIGHT,
            GravityEnum.RIGHT_TOP,
            GravityEnum.RIGHT_BOTTOM,
            GravityEnum.RIGHT_CENTER -> {
                result.align(Alignment.End)
            }

            GravityEnum.CENTER,
            GravityEnum.TOP_CENTER,
            GravityEnum.BOTTOM_CENTER -> {
                result.align(Alignment.CenterHorizontally)
            }

            else -> {
                result
            }
        }

        return result
    }

    @SuppressLint("ModifierFactoryExtensionFunction")
    private fun RowScope.gravity(node: Node): Modifier {
        var result: Modifier = Modifier
        val gravity = node.layoutAttributes.gravity ?: return result

        result = when (gravity.value) {
            GravityEnum.TOP,
            GravityEnum.LEFT_TOP,
            GravityEnum.RIGHT_TOP,
            GravityEnum.TOP_CENTER -> {
                result.align(Alignment.Top)
            }

            GravityEnum.BOTTOM,
            GravityEnum.LEFT_BOTTOM,
            GravityEnum.RIGHT_BOTTOM,
            GravityEnum.BOTTOM_CENTER -> {
                result.align(Alignment.Bottom)
            }

            GravityEnum.CENTER,
            GravityEnum.LEFT_CENTER,
            GravityEnum.RIGHT_CENTER -> {
                result.align(Alignment.CenterVertically)
            }

            else -> {
                result
            }
        }

        return result
    }

    @SuppressLint("ModifierFactoryExtensionFunction")
    private fun BoxScope.gravity(node: Node): Modifier {
        var result: Modifier = Modifier
        val gravity = node.layoutAttributes.gravity ?: return result

        result = when (gravity.value) {
            GravityEnum.TOP,
            GravityEnum.LEFT,
            GravityEnum.LEFT_TOP -> {
                result.align(Alignment.TopStart)
            }

            GravityEnum.RIGHT,
            GravityEnum.RIGHT_TOP -> {
                result.align(Alignment.TopEnd)
            }

            GravityEnum.BOTTOM,
            GravityEnum.LEFT_BOTTOM -> {
                result.align(Alignment.BottomStart)
            }

            GravityEnum.RIGHT_BOTTOM -> {
                result.align(Alignment.BottomEnd)
            }

            GravityEnum.LEFT_CENTER -> {
                result.align(Alignment.CenterStart)
            }

            GravityEnum.RIGHT_CENTER -> {
                result.align(Alignment.CenterEnd)
            }

            GravityEnum.CENTER -> {
                result.align(Alignment.Center)
            }

            GravityEnum.TOP_CENTER -> {
                result.align(Alignment.TopCenter)
            }

            GravityEnum.BOTTOM_CENTER -> {
                result.align(Alignment.BottomCenter)
            }

            else -> {
                result
            }
        }

        return result
    }


    @Composable
    private fun Modifier.renderBaseAttr(
        node: Node,
        realState: MutableState<State>,
        ignoreHeight: Boolean,
        ignoreWidth: Boolean
    ): Modifier {
        var result = this
        val viewAttributes = node.viewAttributes
        val layoutAttributes = node.layoutAttributes
        val tapAttributes = node.tapAttributes

        result = result
            .renderLayoutAttr(layoutAttributes, ignoreHeight, ignoreWidth)
            .renderViewAttr(viewAttributes, realState = realState)
            .renderTapAttr(tapAttributes, realState = realState)

        return result
    }

    private fun Modifier.renderViewAttr(
        viewAttributes: ViewAttributes,
        realState: MutableState<State>
    ): Modifier {
        var result = this
        val testTag = viewAttributes.testTag
        val alpha = viewAttributes.alpha
        val padding = viewAttributes.padding
        val background = viewAttributes.background

        if (testTag != null) {
            result = result.testTag(
                testTag.value ?: getAttrFromExpression(
                    testTag.expression!!,
                    realState = realState
                )
            )
        }

        if (alpha != null) {
            result = result.alpha(
                alpha.value ?: getAttrFromExpression(
                    alpha.expression!!,
                    realState = realState
                )
            )
        }

        if (background != null) {
            val border = background.border
            val width = border?.width

            val colorBorder = border?.color
            val colorBorderValue = if (colorBorder?.value != null) {
                colorBorder.value!!.toColorInt()
            } else if (colorBorder?.expression != null) {
                getAttrFromExpression<String>(
                    colorBorder.expression!!,
                    realState = realState
                ).toColorInt()
            } else {
                0
            }

            val dashSize = border?.dashSize
            val dashGap = border?.dashGap

            val cornersRadius = background.cornerRadius
            val leftTop = cornersRadius?.leftTop.toDp()
            val rightTop = cornersRadius?.rightTop.toDp()
            val leftBottom = cornersRadius?.leftBottom.toDp()
            val rightBottom = cornersRadius?.rightBottom.toDp()

            val color = background.color
            val colorValue = if (color?.value != null) {
                color.value!!.toColorInt()
            } else if (color?.expression != null) {
                getAttrFromExpression<String>(
                    color.expression!!,
                    realState = realState
                ).toColorInt()
            } else {
                0
            }

            val shape = RoundedCornerShape(
                topStart = leftTop,
                topEnd = rightTop,
                bottomStart = leftBottom,
                bottomEnd = rightBottom
            )

            if (width != null) {
                if (dashGap == null || dashSize == null) {
                    result = result.border(
                        width = width.toDp(),
                        color = Color(colorBorderValue),
                        shape = shape
                    )
                } else {
                    val density = Resources.getSystem().displayMetrics.density
                    val stroke = Stroke(
                        width = width.doubleValue.toFloat() * density,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(
                                dashSize.doubleValue.toFloat() * density,
                                dashGap.doubleValue.toFloat() * density
                            ),
                        )
                    )

                    val path = Path()

                    result = result.drawBehind {
                        path.addRoundRect(
                            RoundRect(
                                left = 0f,
                                right = size.width,
                                top = 0f,
                                bottom = size.height,
                                topLeftCornerRadius = CornerRadius(leftTop.value * density),
                                topRightCornerRadius = CornerRadius(rightTop.value * density),
                                bottomLeftCornerRadius = CornerRadius(leftBottom.value * density),
                                bottomRightCornerRadius = CornerRadius(rightBottom.value * density)
                            )
                        )

                        drawPath(
                            path = path,
                            color = Color(colorBorderValue),
                            style = stroke
                        )
                    }
                }
            }

            if (background.color != null) {
                result = result.background(
                    color = Color(colorValue),
                    shape = shape
                )
            }
        }

        if (padding != null) {
            val left = padding.left.toDp()
            val right = padding.right.toDp()
            val top = padding.top.toDp()
            val bottom = padding.bottom.toDp()

            result = result.padding(start = left, top = top, end = right, bottom = bottom)
        }

        return result
    }

    private fun Modifier.renderLayoutAttr(
        layoutAttributes: LayoutAttributes,
        ignoreHeight: Boolean,
        ignoreWidth: Boolean
    ): Modifier {
        var result = this
        val width = layoutAttributes.width
        val height = layoutAttributes.height
        val weight = layoutAttributes.weight
        val margin = layoutAttributes.margin

        if (margin != null) {
            val left = margin.left.toDp()
            val right = margin.right.toDp()
            val top = margin.top.toDp()
            val bottom = margin.bottom.toDp()

            val paddingValues =
                PaddingValues.Absolute(
                    left = left,
                    right = right,
                    top = top,
                    bottom = bottom
                )

            result = result.padding(paddingValues)
        }

        if (!ignoreHeight || weight == null) {
            result = result.setHeight(height)
        }

        if (!ignoreWidth || weight == null) {
            result = result.setWidth(width)
        }

        return result
    }

    private fun Modifier.setHeight(
        height: Dimension?,
    ): Modifier {
        var result = this

        when (height) {
            is Dimension.Match.Fill -> {
                result = result.fillMaxHeight()
            }

            is Dimension.Match.Wrap -> {
                result = result.wrapContentHeight()
            }

            is Dimension.Exact -> {
                result = result.height(height.toDp())
            }

            else -> {
                result = result.wrapContentHeight()
            }
        }

        return result
    }

    private fun Modifier.setWidth(
        width: Dimension?
    ): Modifier {
        var result = this

        when (width) {
            is Dimension.Match.Fill -> {
                result = result.fillMaxWidth()
            }

            is Dimension.Match.Wrap -> {
                result = result.wrapContentWidth()
            }

            is Dimension.Exact -> {
                result = result.width(width.toDp())
            }

            else -> {
                result = result.wrapContentWidth()
            }
        }

        return result
    }

    @OptIn(ExperimentalFoundationApi::class)
    private fun Modifier.renderTapAttr(
        tapAttributes: TapAttributes,
        realState: MutableState<State>
    ): Modifier {
        var result = this
        val onTap = tapAttributes.onTap
        val onLongTap = tapAttributes.onLongTap

        if (onLongTap != null || onTap != null) {
            result = result.combinedClickable(onLongClick = {
                if (onLongTap != null) {
                    for (expression in onLongTap) {
                        changeRealStateVariable(expression, realState)
                    }
                }
            }) {
                if (onTap != null) {
                    for (expression in onTap) {
                        changeRealStateVariable(expression, realState)
                    }
                }
            }
        }

        return result
    }

    private fun changeRealStateVariable(expression: TapExpression, realState: MutableState<State>) {
        val map = realState.value.map
        val attr = getAttrFromExpression<Any>(expression.expressionType, realState)
        map[expression.variableName] = attr
        realState.value = State(map)
    }

    private fun Align.toTextAlign(): TextAlign {
        return when (this) {
            Align.JUSTIFY -> {
                TextAlign.Justify
            }

            Align.CENTER -> {
                TextAlign.Center
            }

            Align.START -> {
                TextAlign.Start
            }

            Align.END -> {
                TextAlign.End
            }
        }
    }

    private fun Overflow.toTextOverflow(): TextOverflow {
        return when (this) {
            Overflow.CLIP -> {
                TextOverflow.Clip
            }

            Overflow.ELLIPSIS -> {
                TextOverflow.Ellipsis
            }
        }
    }

    private fun ResizeMode?.toContentScale(): ContentScale {
        return when (this) {
            ResizeMode.SCALE_TO_FILL -> {
                ContentScale.FillBounds
            }

            ResizeMode.ASPECT_FIT, null -> {
                ContentScale.Fit
            }

            ResizeMode.ASPECT_FILL -> {
                ContentScale.Crop
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    private fun createGlidePlaceholder(
        placeholder: ExpressionWithValue<String>?,
        placeholderTint: ExpressionWithValue<String>?,
        tint: ExpressionWithValue<String>?,
        realState: MutableState<State>,
    ): Placeholder {
        val glidePlaceholder = if (placeholder == null) {
            null
        } else {
            val placeholderTintValue = if (placeholderTint?.value != null) {
                placeholderTint.value!!
            } else if (placeholderTint?.expression != null) {
                getAttrFromExpression<String>(placeholderTint.expression!!, realState = realState)
            } else {
                null
            }

            val tintValue = if (tint?.value != null) {
                tint.value!!
            } else if (tint?.expression != null) {
                getAttrFromExpression<String>(tint.expression!!, realState = realState)
            } else {
                null
            }

            val placeholderValue = if (placeholder.value != null) {
                placeholder.value!!
            } else {
                getAttrFromExpression(placeholder.expression!!, realState = realState)
            }

            ColorDrawable((placeholderTintValue ?: tintValue ?: placeholderValue).toColorInt())
        }.let { placeholder(it) }

        return glidePlaceholder
    }


    private fun Dimension.Exact?.toDp(): Dp {
        return when (this) {
            null -> {
                0.dp
            }

            is Dimension.Exact.AdaptivePoints -> {
                val scale = doubleValue / SCREEN_WIDTH_IN_AP
                val displayMetrics = Resources.getSystem().displayMetrics
                val px =
                    displayMetrics.widthPixels.coerceAtMost(displayMetrics.heightPixels) * scale
                return (px / displayMetrics.density).dp
            }

            is Dimension.Exact.NativePoints -> {
                doubleValue.dp
            }
        }
    }

    private fun Dimension.Exact?.toSp(): TextUnit {
        return when (this) {
            null -> {
                0.sp
            }

            is Dimension.Exact.AdaptivePoints -> {
                (doubleValue / Resources.getSystem().displayMetrics.density).sp
            }

            is Dimension.Exact.NativePoints -> {
                doubleValue.sp
            }
        }
    }

    private fun FontStyle?.toFontFamily(): FontFamily {
        return when (this) {
            FontStyle.Regular -> FontFamily(Font(R.font.inter_regular))
            FontStyle.Bold -> FontFamily(Font(R.font.inter_bold))
            FontStyle.BoldItalic -> FontFamily(Font(R.font.inter_bold_italic))
            FontStyle.ExtraBoldItalic -> FontFamily(Font(R.font.inter_extra_bold_italic))
            FontStyle.SemiBold -> FontFamily(Font(R.font.inter_semi_bold))
            FontStyle.Medium -> FontFamily(Font(R.font.inter_medium))
            FontStyle.AliBold -> FontFamily(Font(R.font.ali_bold))
            FontStyle.AliRegular -> FontFamily(Font(R.font.ali_regular))
            FontStyle.AliLight -> FontFamily(Font(R.font.ali_light))
            else -> FontFamily(Font(R.font.inter_regular))
        }
    }

    private fun createKeyboardOptions(
        keyboardOptions: KeyboardOptions?,
        realState: MutableState<State>
    ): ComposeKeyboardOptions {
        val capitalization = keyboardOptions?.capitalization.toComposeCapitalization()

        val autoCorrect = keyboardOptions?.autoCorrect
        val autoCorrectValue = if (autoCorrect?.value != null) {
            autoCorrect.value!!
        } else if (autoCorrect?.expression != null) {
            getAttrFromExpression(
                autoCorrect.expression!!,
                realState = realState
            )
        } else {
            false
        }

        val keyboardType = keyboardOptions?.keyboardType.toComposeKeyboardType()
        val imeAction = keyboardOptions?.imeAction.toComposeIme()

        return ComposeKeyboardOptions(
            capitalization = capitalization,
            autoCorrect = autoCorrectValue,
            keyboardType = keyboardType,
            imeAction = imeAction,
        )
    }

    private fun KeyboardCapitalization?.toComposeCapitalization(): ComposeCapitalization {
        return when (this) {
            KeyboardCapitalization.NONE -> {
                ComposeCapitalization.None
            }

            KeyboardCapitalization.CHARACTERS -> {
                ComposeCapitalization.Characters
            }

            KeyboardCapitalization.WORDS -> {
                ComposeCapitalization.Words
            }

            KeyboardCapitalization.SENTENCES -> {
                ComposeCapitalization.Sentences
            }

            else -> {
                ComposeCapitalization.None
            }
        }
    }

    private fun KeyboardType?.toComposeKeyboardType(): ComposeKeyboardType {
        return when (this) {
            KeyboardType.TEXT -> {
                ComposeKeyboardType.Text
            }

            KeyboardType.ASCII -> {
                ComposeKeyboardType.Ascii
            }

            KeyboardType.NUMBER -> {
                ComposeKeyboardType.Number
            }

            KeyboardType.PHONE -> {
                ComposeKeyboardType.Phone
            }

            KeyboardType.URI -> {
                ComposeKeyboardType.Uri
            }

            KeyboardType.EMAIL -> {
                ComposeKeyboardType.Email
            }

            KeyboardType.PASSWORD -> {
                ComposeKeyboardType.Password
            }

            KeyboardType.NUMBER_PASSWORD -> {
                ComposeKeyboardType.NumberPassword
            }

            else -> {
                ComposeKeyboardType.Text
            }
        }
    }

    private fun ImeAction?.toComposeIme(): ComposeImeAction {
        return when (this) {
            ImeAction.DEFAULT -> {
                ComposeImeAction.Default
            }

            ImeAction.NONE -> {
                ComposeImeAction.None
            }

            ImeAction.GO -> {
                ComposeImeAction.Go
            }

            ImeAction.SEARCH -> {
                ComposeImeAction.Search
            }

            ImeAction.SEND -> {
                ComposeImeAction.Send
            }

            ImeAction.PREVIOUS -> {
                ComposeImeAction.Previous
            }

            ImeAction.NEXT -> {
                ComposeImeAction.Next
            }

            ImeAction.DONE -> {
                ComposeImeAction.Done
            }

            else -> {
                ComposeImeAction.Default
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> getAttrFromExpression(
        attrExpression: AttrExpressionType,
        realState: MutableState<State>
    ): T {
        when (attrExpression) {
            is AttrExpressionType.FieldExpr -> {
                val name = attrExpression.name

                return when (val getExpression = attrExpression.get) {
                    is GetExpression.IntGet -> {
                        (realState.value[name] as FList<T>)[getExpression.value]
                    }

                    is GetExpression.StringGet -> {
                        (realState.value[name] as FMap<T>)[getExpression.value] as T
                    }

                    null -> {
                        realState.value[name] as T
                    }
                }
            }

            is AttrExpressionType.IfThen -> {
                val condition = attrExpression.condition
                val trueValue = attrExpression.trueValue
                val falseValue = attrExpression.falseValue
                val firstArg = condition.firstArg
                val equals = condition.equals
                val secondArg = condition.secondArg

                return when (equals) {
                    null -> {
                        when (firstArg) {
                            is Const.BooleanConst -> {
                                if (firstArg.value) {
                                    when (trueValue) {
                                        is AttrExpressionType.FieldExpr -> {
                                            getAttrFromExpression(trueValue, realState)
                                        }

                                        is Const -> {
                                            trueValue.value as T
                                        }
                                    }
                                } else {
                                    when (falseValue) {
                                        is AttrExpressionType.FieldExpr -> {
                                            getAttrFromExpression(falseValue, realState)
                                        }

                                        is Const -> {
                                            falseValue.value as T
                                        }

                                        else -> throw IllegalArgumentException()
                                    }
                                }
                            }

                            else -> throw IllegalArgumentException()
                        }
                    }

                    true -> {
                        val secondArgAttr = getAttrFromExpression<Boolean>(secondArg!!, realState)

                        if (secondArgAttr == firstArg.value) {
                            when (trueValue) {
                                is AttrExpressionType.FieldExpr -> {
                                    getAttrFromExpression(trueValue, realState)
                                }

                                is Const -> {
                                    trueValue.value as T
                                }
                            }
                        } else {
                            when (falseValue) {
                                is AttrExpressionType.FieldExpr -> {
                                    getAttrFromExpression(falseValue, realState)
                                }

                                is Const -> {
                                    falseValue.value as T
                                }

                                else -> {
                                    throw IllegalArgumentException()
                                }
                            }
                        }
                    }

                    false -> {
                        val secondArgAttr = getAttrFromExpression<Boolean>(secondArg!!, realState)

                        if (secondArgAttr != firstArg.value) {
                            when (trueValue) {
                                is AttrExpressionType.FieldExpr -> {
                                    getAttrFromExpression(trueValue, realState)
                                }

                                is Const -> {
                                    trueValue.value as T
                                }
                            }

                        } else {
                            when (falseValue) {
                                is AttrExpressionType.FieldExpr -> {
                                    getAttrFromExpression(falseValue, realState)
                                }

                                is Const -> {
                                    falseValue.value as T
                                }

                                else -> {
                                    throw IllegalArgumentException()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private const val SCREEN_WIDTH_IN_AP = 375
