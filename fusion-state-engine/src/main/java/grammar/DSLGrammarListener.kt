package grammar

import grammar.DSLGrammarParser.*
import org.antlr.v4.runtime.tree.ParseTreeListener

/**
 * This interface defines a complete listener for a parse tree produced by
 * [DSLGrammarParser].
 */
interface DSLGrammarListener : ParseTreeListener {
    /**
     * Enter a parse tree produced by [DSLGrammarParser.start].
     * @param ctx the parse tree
     */
    fun enterStart(ctx: StartContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.start].
     * @param ctx the parse tree
     */
    fun exitStart(ctx: StartContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fields].
     * @param ctx the parse tree
     */
    fun enterFields(ctx: FieldsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fields].
     * @param ctx the parse tree
     */
    fun exitFields(ctx: FieldsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.typeValue].
     * @param ctx the parse tree
     */
    fun enterTypeValue(ctx: TypeValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.typeValue].
     * @param ctx the parse tree
     */
    fun exitTypeValue(ctx: TypeValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fStringArray].
     * @param ctx the parse tree
     */
    fun enterFStringArray(ctx: FStringArrayContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fStringArray].
     * @param ctx the parse tree
     */
    fun exitFStringArray(ctx: FStringArrayContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fBooleanArray].
     * @param ctx the parse tree
     */
    fun enterFBooleanArray(ctx: FBooleanArrayContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fBooleanArray].
     * @param ctx the parse tree
     */
    fun exitFBooleanArray(ctx: FBooleanArrayContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fDoubleArray].
     * @param ctx the parse tree
     */
    fun enterFDoubleArray(ctx: FDoubleArrayContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fDoubleArray].
     * @param ctx the parse tree
     */
    fun exitFDoubleArray(ctx: FDoubleArrayContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fLongArray].
     * @param ctx the parse tree
     */
    fun enterFLongArray(ctx: FLongArrayContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fLongArray].
     * @param ctx the parse tree
     */
    fun exitFLongArray(ctx: FLongArrayContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fstringArrValue].
     * @param ctx the parse tree
     */
    fun enterFstringArrValue(ctx: FstringArrValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fstringArrValue].
     * @param ctx the parse tree
     */
    fun exitFstringArrValue(ctx: FstringArrValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fbooleanArrValue].
     * @param ctx the parse tree
     */
    fun enterFbooleanArrValue(ctx: FbooleanArrValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fbooleanArrValue].
     * @param ctx the parse tree
     */
    fun exitFbooleanArrValue(ctx: FbooleanArrValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fdoubleArrValue].
     * @param ctx the parse tree
     */
    fun enterFdoubleArrValue(ctx: FdoubleArrValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fdoubleArrValue].
     * @param ctx the parse tree
     */
    fun exitFdoubleArrValue(ctx: FdoubleArrValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.flongArrValue].
     * @param ctx the parse tree
     */
    fun enterFlongArrValue(ctx: FlongArrValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.flongArrValue].
     * @param ctx the parse tree
     */
    fun exitFlongArrValue(ctx: FlongArrValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fStringDictionary].
     * @param ctx the parse tree
     */
    fun enterFStringDictionary(ctx: FStringDictionaryContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fStringDictionary].
     * @param ctx the parse tree
     */
    fun exitFStringDictionary(ctx: FStringDictionaryContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fDoubleDictionary].
     * @param ctx the parse tree
     */
    fun enterFDoubleDictionary(ctx: FDoubleDictionaryContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fDoubleDictionary].
     * @param ctx the parse tree
     */
    fun exitFDoubleDictionary(ctx: FDoubleDictionaryContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fLongDictionary].
     * @param ctx the parse tree
     */
    fun enterFLongDictionary(ctx: FLongDictionaryContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fLongDictionary].
     * @param ctx the parse tree
     */
    fun exitFLongDictionary(ctx: FLongDictionaryContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fBooleanDictionary].
     * @param ctx the parse tree
     */
    fun enterFBooleanDictionary(ctx: FBooleanDictionaryContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fBooleanDictionary].
     * @param ctx the parse tree
     */
    fun exitFBooleanDictionary(ctx: FBooleanDictionaryContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fstringDictValue].
     * @param ctx the parse tree
     */
    fun enterFstringDictValue(ctx: FstringDictValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fstringDictValue].
     * @param ctx the parse tree
     */
    fun exitFstringDictValue(ctx: FstringDictValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fdoubleDictValue].
     * @param ctx the parse tree
     */
    fun enterFdoubleDictValue(ctx: FdoubleDictValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fdoubleDictValue].
     * @param ctx the parse tree
     */
    fun exitFdoubleDictValue(ctx: FdoubleDictValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.flongDictValue].
     * @param ctx the parse tree
     */
    fun enterFlongDictValue(ctx: FlongDictValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.flongDictValue].
     * @param ctx the parse tree
     */
    fun exitFlongDictValue(ctx: FlongDictValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fbooleanDictValue].
     * @param ctx the parse tree
     */
    fun enterFbooleanDictValue(ctx: FbooleanDictValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fbooleanDictValue].
     * @param ctx the parse tree
     */
    fun exitFbooleanDictValue(ctx: FbooleanDictValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.layoutNode].
     * @param ctx the parse tree
     */
    fun enterLayoutNode(ctx: LayoutNodeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.layoutNode].
     * @param ctx the parse tree
     */
    fun exitLayoutNode(ctx: LayoutNodeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.node].
     * @param ctx the parse tree
     */
    fun enterNode(ctx: NodeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.node].
     * @param ctx the parse tree
     */
    fun exitNode(ctx: NodeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.box].
     * @param ctx the parse tree
     */
    fun enterBox(ctx: BoxContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.box].
     * @param ctx the parse tree
     */
    fun exitBox(ctx: BoxContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.column].
     * @param ctx the parse tree
     */
    fun enterColumn(ctx: ColumnContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.column].
     * @param ctx the parse tree
     */
    fun exitColumn(ctx: ColumnContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.row].
     * @param ctx the parse tree
     */
    fun enterRow(ctx: RowContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.row].
     * @param ctx the parse tree
     */
    fun exitRow(ctx: RowContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.flowRow].
     * @param ctx the parse tree
     */
    fun enterFlowRow(ctx: FlowRowContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.flowRow].
     * @param ctx the parse tree
     */
    fun exitFlowRow(ctx: FlowRowContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.lazyColumn].
     * @param ctx the parse tree
     */
    fun enterLazyColumn(ctx: LazyColumnContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.lazyColumn].
     * @param ctx the parse tree
     */
    fun exitLazyColumn(ctx: LazyColumnContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.lazyRow].
     * @param ctx the parse tree
     */
    fun enterLazyRow(ctx: LazyRowContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.lazyRow].
     * @param ctx the parse tree
     */
    fun exitLazyRow(ctx: LazyRowContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.item].
     * @param ctx the parse tree
     */
    fun enterItem(ctx: ItemContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.item].
     * @param ctx the parse tree
     */
    fun exitItem(ctx: ItemContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.items].
     * @param ctx the parse tree
     */
    fun enterItems(ctx: ItemsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.items].
     * @param ctx the parse tree
     */
    fun exitItems(ctx: ItemsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.attrExpression].
     * @param ctx the parse tree
     */
    fun enterAttrExpression(ctx: AttrExpressionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.attrExpression].
     * @param ctx the parse tree
     */
    fun exitAttrExpression(ctx: AttrExpressionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.ifExpr].
     * @param ctx the parse tree
     */
    fun enterIfExpr(ctx: IfExprContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.ifExpr].
     * @param ctx the parse tree
     */
    fun exitIfExpr(ctx: IfExprContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.condition].
     * @param ctx the parse tree
     */
    fun enterCondition(ctx: ConditionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.condition].
     * @param ctx the parse tree
     */
    fun exitCondition(ctx: ConditionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.consts].
     * @param ctx the parse tree
     */
    fun enterConsts(ctx: ConstsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.consts].
     * @param ctx the parse tree
     */
    fun exitConsts(ctx: ConstsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fieldExpr].
     * @param ctx the parse tree
     */
    fun enterFieldExpr(ctx: FieldExprContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fieldExpr].
     * @param ctx the parse tree
     */
    fun exitFieldExpr(ctx: FieldExprContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.ifValues].
     * @param ctx the parse tree
     */
    fun enterIfValues(ctx: IfValuesContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.ifValues].
     * @param ctx the parse tree
     */
    fun exitIfValues(ctx: IfValuesContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.layoutAttr].
     * @param ctx the parse tree
     */
    fun enterLayoutAttr(ctx: LayoutAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.layoutAttr].
     * @param ctx the parse tree
     */
    fun exitLayoutAttr(ctx: LayoutAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.width].
     * @param ctx the parse tree
     */
    fun enterWidth(ctx: WidthContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.width].
     * @param ctx the parse tree
     */
    fun exitWidth(ctx: WidthContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.height].
     * @param ctx the parse tree
     */
    fun enterHeight(ctx: HeightContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.height].
     * @param ctx the parse tree
     */
    fun exitHeight(ctx: HeightContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.weight].
     * @param ctx the parse tree
     */
    fun enterWeight(ctx: WeightContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.weight].
     * @param ctx the parse tree
     */
    fun exitWeight(ctx: WeightContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.gravity].
     * @param ctx the parse tree
     */
    fun enterGravity(ctx: GravityContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.gravity].
     * @param ctx the parse tree
     */
    fun exitGravity(ctx: GravityContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.gravityExpression].
     * @param ctx the parse tree
     */
    fun enterGravityExpression(ctx: GravityExpressionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.gravityExpression].
     * @param ctx the parse tree
     */
    fun exitGravityExpression(ctx: GravityExpressionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.gravityValue].
     * @param ctx the parse tree
     */
    fun enterGravityValue(ctx: GravityValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.gravityValue].
     * @param ctx the parse tree
     */
    fun exitGravityValue(ctx: GravityValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.margin].
     * @param ctx the parse tree
     */
    fun enterMargin(ctx: MarginContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.margin].
     * @param ctx the parse tree
     */
    fun exitMargin(ctx: MarginContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.insets].
     * @param ctx the parse tree
     */
    fun enterInsets(ctx: InsetsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.insets].
     * @param ctx the parse tree
     */
    fun exitInsets(ctx: InsetsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.insetsName].
     * @param ctx the parse tree
     */
    fun enterInsetsName(ctx: InsetsNameContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.insetsName].
     * @param ctx the parse tree
     */
    fun exitInsetsName(ctx: InsetsNameContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.dimension].
     * @param ctx the parse tree
     */
    fun enterDimension(ctx: DimensionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.dimension].
     * @param ctx the parse tree
     */
    fun exitDimension(ctx: DimensionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.match].
     * @param ctx the parse tree
     */
    fun enterMatch(ctx: MatchContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.match].
     * @param ctx the parse tree
     */
    fun exitMatch(ctx: MatchContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.exact].
     * @param ctx the parse tree
     */
    fun enterExact(ctx: ExactContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.exact].
     * @param ctx the parse tree
     */
    fun exitExact(ctx: ExactContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.viewAttr].
     * @param ctx the parse tree
     */
    fun enterViewAttr(ctx: ViewAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.viewAttr].
     * @param ctx the parse tree
     */
    fun exitViewAttr(ctx: ViewAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.testTag].
     * @param ctx the parse tree
     */
    fun enterTestTag(ctx: TestTagContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.testTag].
     * @param ctx the parse tree
     */
    fun exitTestTag(ctx: TestTagContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.alpha].
     * @param ctx the parse tree
     */
    fun enterAlpha(ctx: AlphaContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.alpha].
     * @param ctx the parse tree
     */
    fun exitAlpha(ctx: AlphaContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.padding].
     * @param ctx the parse tree
     */
    fun enterPadding(ctx: PaddingContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.padding].
     * @param ctx the parse tree
     */
    fun exitPadding(ctx: PaddingContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.background].
     * @param ctx the parse tree
     */
    fun enterBackground(ctx: BackgroundContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.background].
     * @param ctx the parse tree
     */
    fun exitBackground(ctx: BackgroundContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.backgroundValue].
     * @param ctx the parse tree
     */
    fun enterBackgroundValue(ctx: BackgroundValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.backgroundValue].
     * @param ctx the parse tree
     */
    fun exitBackgroundValue(ctx: BackgroundValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.border].
     * @param ctx the parse tree
     */
    fun enterBorder(ctx: BorderContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.border].
     * @param ctx the parse tree
     */
    fun exitBorder(ctx: BorderContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.borderAttr].
     * @param ctx the parse tree
     */
    fun enterBorderAttr(ctx: BorderAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.borderAttr].
     * @param ctx the parse tree
     */
    fun exitBorderAttr(ctx: BorderAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.widthExact].
     * @param ctx the parse tree
     */
    fun enterWidthExact(ctx: WidthExactContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.widthExact].
     * @param ctx the parse tree
     */
    fun exitWidthExact(ctx: WidthExactContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.dashSize].
     * @param ctx the parse tree
     */
    fun enterDashSize(ctx: DashSizeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.dashSize].
     * @param ctx the parse tree
     */
    fun exitDashSize(ctx: DashSizeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.dashGap].
     * @param ctx the parse tree
     */
    fun enterDashGap(ctx: DashGapContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.dashGap].
     * @param ctx the parse tree
     */
    fun exitDashGap(ctx: DashGapContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.cornersRadius].
     * @param ctx the parse tree
     */
    fun enterCornersRadius(ctx: CornersRadiusContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.cornersRadius].
     * @param ctx the parse tree
     */
    fun exitCornersRadius(ctx: CornersRadiusContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.corners].
     * @param ctx the parse tree
     */
    fun enterCorners(ctx: CornersContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.corners].
     * @param ctx the parse tree
     */
    fun exitCorners(ctx: CornersContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.cornerName].
     * @param ctx the parse tree
     */
    fun enterCornerName(ctx: CornerNameContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.cornerName].
     * @param ctx the parse tree
     */
    fun exitCornerName(ctx: CornerNameContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.color].
     * @param ctx the parse tree
     */
    fun enterColor(ctx: ColorContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.color].
     * @param ctx the parse tree
     */
    fun exitColor(ctx: ColorContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.colorHEX].
     * @param ctx the parse tree
     */
    fun enterColorHEX(ctx: ColorHEXContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.colorHEX].
     * @param ctx the parse tree
     */
    fun exitColorHEX(ctx: ColorHEXContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.isEnabled].
     * @param ctx the parse tree
     */
    fun enterIsEnabled(ctx: IsEnabledContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.isEnabled].
     * @param ctx the parse tree
     */
    fun exitIsEnabled(ctx: IsEnabledContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.isVisible].
     * @param ctx the parse tree
     */
    fun enterIsVisible(ctx: IsVisibleContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.isVisible].
     * @param ctx the parse tree
     */
    fun exitIsVisible(ctx: IsVisibleContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.tapAttr].
     * @param ctx the parse tree
     */
    fun enterTapAttr(ctx: TapAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.tapAttr].
     * @param ctx the parse tree
     */
    fun exitTapAttr(ctx: TapAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.onTap].
     * @param ctx the parse tree
     */
    fun enterOnTap(ctx: OnTapContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.onTap].
     * @param ctx the parse tree
     */
    fun exitOnTap(ctx: OnTapContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.onLongTap].
     * @param ctx the parse tree
     */
    fun enterOnLongTap(ctx: OnLongTapContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.onLongTap].
     * @param ctx the parse tree
     */
    fun exitOnLongTap(ctx: OnLongTapContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.onPressedChange].
     * @param ctx the parse tree
     */
    fun enterOnPressedChange(ctx: OnPressedChangeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.onPressedChange].
     * @param ctx the parse tree
     */
    fun exitOnPressedChange(ctx: OnPressedChangeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.tapExpression].
     * @param ctx the parse tree
     */
    fun enterTapExpression(ctx: TapExpressionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.tapExpression].
     * @param ctx the parse tree
     */
    fun exitTapExpression(ctx: TapExpressionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.mapExpr].
     * @param ctx the parse tree
     */
    fun enterMapExpr(ctx: MapExprContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.mapExpr].
     * @param ctx the parse tree
     */
    fun exitMapExpr(ctx: MapExprContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.filterExpr].
     * @param ctx the parse tree
     */
    fun enterFilterExpr(ctx: FilterExprContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.filterExpr].
     * @param ctx the parse tree
     */
    fun exitFilterExpr(ctx: FilterExprContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.lambdaParams].
     * @param ctx the parse tree
     */
    fun enterLambdaParams(ctx: LambdaParamsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.lambdaParams].
     * @param ctx the parse tree
     */
    fun exitLambdaParams(ctx: LambdaParamsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.flowRowAttr].
     * @param ctx the parse tree
     */
    fun enterFlowRowAttr(ctx: FlowRowAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.flowRowAttr].
     * @param ctx the parse tree
     */
    fun exitFlowRowAttr(ctx: FlowRowAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.maxLinesCount].
     * @param ctx the parse tree
     */
    fun enterMaxLinesCount(ctx: MaxLinesCountContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.maxLinesCount].
     * @param ctx the parse tree
     */
    fun exitMaxLinesCount(ctx: MaxLinesCountContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.horizontalSpacing].
     * @param ctx the parse tree
     */
    fun enterHorizontalSpacing(ctx: HorizontalSpacingContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.horizontalSpacing].
     * @param ctx the parse tree
     */
    fun exitHorizontalSpacing(ctx: HorizontalSpacingContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.verticalSpacing].
     * @param ctx the parse tree
     */
    fun enterVerticalSpacing(ctx: VerticalSpacingContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.verticalSpacing].
     * @param ctx the parse tree
     */
    fun exitVerticalSpacing(ctx: VerticalSpacingContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textNode].
     * @param ctx the parse tree
     */
    fun enterTextNode(ctx: TextNodeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textNode].
     * @param ctx the parse tree
     */
    fun exitTextNode(ctx: TextNodeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textAttr].
     * @param ctx the parse tree
     */
    fun enterTextAttr(ctx: TextAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textAttr].
     * @param ctx the parse tree
     */
    fun exitTextAttr(ctx: TextAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.text].
     * @param ctx the parse tree
     */
    fun enterText(ctx: TextContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.text].
     * @param ctx the parse tree
     */
    fun exitText(ctx: TextContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textConfig].
     * @param ctx the parse tree
     */
    fun enterTextConfig(ctx: TextConfigContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textConfig].
     * @param ctx the parse tree
     */
    fun exitTextConfig(ctx: TextConfigContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.configAttr].
     * @param ctx the parse tree
     */
    fun enterConfigAttr(ctx: ConfigAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.configAttr].
     * @param ctx the parse tree
     */
    fun exitConfigAttr(ctx: ConfigAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fontSize].
     * @param ctx the parse tree
     */
    fun enterFontSize(ctx: FontSizeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fontSize].
     * @param ctx the parse tree
     */
    fun exitFontSize(ctx: FontSizeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fontStyle].
     * @param ctx the parse tree
     */
    fun enterFontStyle(ctx: FontStyleContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fontStyle].
     * @param ctx the parse tree
     */
    fun exitFontStyle(ctx: FontStyleContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.fontStyleValue].
     * @param ctx the parse tree
     */
    fun enterFontStyleValue(ctx: FontStyleValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.fontStyleValue].
     * @param ctx the parse tree
     */
    fun exitFontStyleValue(ctx: FontStyleValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.isUnderline].
     * @param ctx the parse tree
     */
    fun enterIsUnderline(ctx: IsUnderlineContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.isUnderline].
     * @param ctx the parse tree
     */
    fun exitIsUnderline(ctx: IsUnderlineContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.isStrikeThrough].
     * @param ctx the parse tree
     */
    fun enterIsStrikeThrough(ctx: IsStrikeThroughContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.isStrikeThrough].
     * @param ctx the parse tree
     */
    fun exitIsStrikeThrough(ctx: IsStrikeThroughContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.align].
     * @param ctx the parse tree
     */
    fun enterAlign(ctx: AlignContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.align].
     * @param ctx the parse tree
     */
    fun exitAlign(ctx: AlignContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.alignValue].
     * @param ctx the parse tree
     */
    fun enterAlignValue(ctx: AlignValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.alignValue].
     * @param ctx the parse tree
     */
    fun exitAlignValue(ctx: AlignValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.overflow].
     * @param ctx the parse tree
     */
    fun enterOverflow(ctx: OverflowContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.overflow].
     * @param ctx the parse tree
     */
    fun exitOverflow(ctx: OverflowContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.overflowValue].
     * @param ctx the parse tree
     */
    fun enterOverflowValue(ctx: OverflowValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.overflowValue].
     * @param ctx the parse tree
     */
    fun exitOverflowValue(ctx: OverflowValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.maxLines].
     * @param ctx the parse tree
     */
    fun enterMaxLines(ctx: MaxLinesContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.maxLines].
     * @param ctx the parse tree
     */
    fun exitMaxLines(ctx: MaxLinesContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.lineHeight].
     * @param ctx the parse tree
     */
    fun enterLineHeight(ctx: LineHeightContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.lineHeight].
     * @param ctx the parse tree
     */
    fun exitLineHeight(ctx: LineHeightContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.letterSpacing].
     * @param ctx the parse tree
     */
    fun enterLetterSpacing(ctx: LetterSpacingContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.letterSpacing].
     * @param ctx the parse tree
     */
    fun exitLetterSpacing(ctx: LetterSpacingContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.imageNode].
     * @param ctx the parse tree
     */
    fun enterImageNode(ctx: ImageNodeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.imageNode].
     * @param ctx the parse tree
     */
    fun exitImageNode(ctx: ImageNodeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.imageAttr].
     * @param ctx the parse tree
     */
    fun enterImageAttr(ctx: ImageAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.imageAttr].
     * @param ctx the parse tree
     */
    fun exitImageAttr(ctx: ImageAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.source].
     * @param ctx the parse tree
     */
    fun enterSource(ctx: SourceContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.source].
     * @param ctx the parse tree
     */
    fun exitSource(ctx: SourceContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.placeholder].
     * @param ctx the parse tree
     */
    fun enterPlaceholder(ctx: PlaceholderContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.placeholder].
     * @param ctx the parse tree
     */
    fun exitPlaceholder(ctx: PlaceholderContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.placeholderTint].
     * @param ctx the parse tree
     */
    fun enterPlaceholderTint(ctx: PlaceholderTintContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.placeholderTint].
     * @param ctx the parse tree
     */
    fun exitPlaceholderTint(ctx: PlaceholderTintContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.tint].
     * @param ctx the parse tree
     */
    fun enterTint(ctx: TintContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.tint].
     * @param ctx the parse tree
     */
    fun exitTint(ctx: TintContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.resizeMode].
     * @param ctx the parse tree
     */
    fun enterResizeMode(ctx: ResizeModeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.resizeMode].
     * @param ctx the parse tree
     */
    fun exitResizeMode(ctx: ResizeModeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.resizeModeValue].
     * @param ctx the parse tree
     */
    fun enterResizeModeValue(ctx: ResizeModeValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.resizeModeValue].
     * @param ctx the parse tree
     */
    fun exitResizeModeValue(ctx: ResizeModeValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.animateChanges].
     * @param ctx the parse tree
     */
    fun enterAnimateChanges(ctx: AnimateChangesContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.animateChanges].
     * @param ctx the parse tree
     */
    fun exitAnimateChanges(ctx: AnimateChangesContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.animateChangesValue].
     * @param ctx the parse tree
     */
    fun enterAnimateChangesValue(ctx: AnimateChangesValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.animateChangesValue].
     * @param ctx the parse tree
     */
    fun exitAnimateChangesValue(ctx: AnimateChangesValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textFieldNode].
     * @param ctx the parse tree
     */
    fun enterTextFieldNode(ctx: TextFieldNodeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textFieldNode].
     * @param ctx the parse tree
     */
    fun exitTextFieldNode(ctx: TextFieldNodeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textFieldAttr].
     * @param ctx the parse tree
     */
    fun enterTextFieldAttr(ctx: TextFieldAttrContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textFieldAttr].
     * @param ctx the parse tree
     */
    fun exitTextFieldAttr(ctx: TextFieldAttrContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.textFieldConfig].
     * @param ctx the parse tree
     */
    fun enterTextFieldConfig(ctx: TextFieldConfigContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.textFieldConfig].
     * @param ctx the parse tree
     */
    fun exitTextFieldConfig(ctx: TextFieldConfigContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.keyboardOptions].
     * @param ctx the parse tree
     */
    fun enterKeyboardOptions(ctx: KeyboardOptionsContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.keyboardOptions].
     * @param ctx the parse tree
     */
    fun exitKeyboardOptions(ctx: KeyboardOptionsContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.keyboardOptionsValue].
     * @param ctx the parse tree
     */
    fun enterKeyboardOptionsValue(ctx: KeyboardOptionsValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.keyboardOptionsValue].
     * @param ctx the parse tree
     */
    fun exitKeyboardOptionsValue(ctx: KeyboardOptionsValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.capitalization].
     * @param ctx the parse tree
     */
    fun enterCapitalization(ctx: CapitalizationContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.capitalization].
     * @param ctx the parse tree
     */
    fun exitCapitalization(ctx: CapitalizationContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.capitalizationValue].
     * @param ctx the parse tree
     */
    fun enterCapitalizationValue(ctx: CapitalizationValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.capitalizationValue].
     * @param ctx the parse tree
     */
    fun exitCapitalizationValue(ctx: CapitalizationValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.autoCorrect].
     * @param ctx the parse tree
     */
    fun enterAutoCorrect(ctx: AutoCorrectContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.autoCorrect].
     * @param ctx the parse tree
     */
    fun exitAutoCorrect(ctx: AutoCorrectContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.keyboardType].
     * @param ctx the parse tree
     */
    fun enterKeyboardType(ctx: KeyboardTypeContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.keyboardType].
     * @param ctx the parse tree
     */
    fun exitKeyboardType(ctx: KeyboardTypeContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.keyboardTypeValue].
     * @param ctx the parse tree
     */
    fun enterKeyboardTypeValue(ctx: KeyboardTypeValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.keyboardTypeValue].
     * @param ctx the parse tree
     */
    fun exitKeyboardTypeValue(ctx: KeyboardTypeValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.imeAction].
     * @param ctx the parse tree
     */
    fun enterImeAction(ctx: ImeActionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.imeAction].
     * @param ctx the parse tree
     */
    fun exitImeAction(ctx: ImeActionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.imeActionValue].
     * @param ctx the parse tree
     */
    fun enterImeActionValue(ctx: ImeActionValueContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.imeActionValue].
     * @param ctx the parse tree
     */
    fun exitImeActionValue(ctx: ImeActionValueContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.inputAccessoryAction].
     * @param ctx the parse tree
     */
    fun enterInputAccessoryAction(ctx: InputAccessoryActionContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.inputAccessoryAction].
     * @param ctx the parse tree
     */
    fun exitInputAccessoryAction(ctx: InputAccessoryActionContext?)

    /**
     * Enter a parse tree produced by [DSLGrammarParser.isMultiline].
     * @param ctx the parse tree
     */
    fun enterIsMultiline(ctx: IsMultilineContext?)

    /**
     * Exit a parse tree produced by [DSLGrammarParser.isMultiline].
     * @param ctx the parse tree
     */
    fun exitIsMultiline(ctx: IsMultilineContext?)
}