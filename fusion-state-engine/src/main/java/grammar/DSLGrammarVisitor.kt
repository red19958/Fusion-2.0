package grammar

import grammar.DSLGrammarParser.*
import org.antlr.v4.runtime.tree.ParseTreeVisitor

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by [DSLGrammarParser].
 *
 * @param <T> The return type of the visit operation. Use [Void] for
 * operations with no return type.
</T> */
interface DSLGrammarVisitor<T> : ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by [DSLGrammarParser.start].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitStart(ctx: StartContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fields].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFields(ctx: FieldsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.typeValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTypeValue(ctx: TypeValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fStringArray].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFStringArray(ctx: FStringArrayContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fBooleanArray].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFBooleanArray(ctx: FBooleanArrayContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fDoubleArray].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFDoubleArray(ctx: FDoubleArrayContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fLongArray].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFLongArray(ctx: FLongArrayContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fstringArrValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFstringArrValue(ctx: FstringArrValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fbooleanArrValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFbooleanArrValue(ctx: FbooleanArrValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fdoubleArrValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFdoubleArrValue(ctx: FdoubleArrValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.flongArrValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFlongArrValue(ctx: FlongArrValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fStringDictionary].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFStringDictionary(ctx: FStringDictionaryContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fDoubleDictionary].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFDoubleDictionary(ctx: FDoubleDictionaryContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fLongDictionary].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFLongDictionary(ctx: FLongDictionaryContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fBooleanDictionary].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFBooleanDictionary(ctx: FBooleanDictionaryContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fstringDictValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFstringDictValue(ctx: FstringDictValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fdoubleDictValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFdoubleDictValue(ctx: FdoubleDictValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.flongDictValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFlongDictValue(ctx: FlongDictValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fbooleanDictValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFbooleanDictValue(ctx: FbooleanDictValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.layoutNode].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLayoutNode(ctx: LayoutNodeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.node].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitNode(ctx: NodeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.box].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBox(ctx: BoxContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.column].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitColumn(ctx: ColumnContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.row].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRow(ctx: RowContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.flowRow].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFlowRow(ctx: FlowRowContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.lazyColumn].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLazyColumn(ctx: LazyColumnContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.lazyRow].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLazyRow(ctx: LazyRowContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.item].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitItem(ctx: ItemContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.items].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitItems(ctx: ItemsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.attrExpression].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAttrExpression(ctx: AttrExpressionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.ifExpr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIfExpr(ctx: IfExprContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.condition].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCondition(ctx: ConditionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.consts].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitConsts(ctx: ConstsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fieldExpr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFieldExpr(ctx: FieldExprContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.ifValues].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIfValues(ctx: IfValuesContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.layoutAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLayoutAttr(ctx: LayoutAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.width].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitWidth(ctx: WidthContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.height].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitHeight(ctx: HeightContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.weight].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitWeight(ctx: WeightContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.gravity].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitGravity(ctx: GravityContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.gravityExpression].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitGravityExpression(ctx: GravityExpressionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.gravityValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitGravityValue(ctx: GravityValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.margin].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMargin(ctx: MarginContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.insets].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitInsets(ctx: InsetsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.insetsName].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitInsetsName(ctx: InsetsNameContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.dimension].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDimension(ctx: DimensionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.match].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMatch(ctx: MatchContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.exact].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitExact(ctx: ExactContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.viewAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitViewAttr(ctx: ViewAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.testTag].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTestTag(ctx: TestTagContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.alpha].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAlpha(ctx: AlphaContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.padding].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitPadding(ctx: PaddingContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.background].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBackground(ctx: BackgroundContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.backgroundValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBackgroundValue(ctx: BackgroundValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.border].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBorder(ctx: BorderContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.borderAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBorderAttr(ctx: BorderAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.widthExact].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitWidthExact(ctx: WidthExactContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.dashSize].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDashSize(ctx: DashSizeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.dashGap].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDashGap(ctx: DashGapContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.cornersRadius].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCornersRadius(ctx: CornersRadiusContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.corners].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCorners(ctx: CornersContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.cornerName].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCornerName(ctx: CornerNameContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.color].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitColor(ctx: ColorContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.colorHEX].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitColorHEX(ctx: ColorHEXContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.isEnabled].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIsEnabled(ctx: IsEnabledContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.isVisible].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIsVisible(ctx: IsVisibleContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.tapAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTapAttr(ctx: TapAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.onTap].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitOnTap(ctx: OnTapContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.onLongTap].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitOnLongTap(ctx: OnLongTapContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.onPressedChange].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitOnPressedChange(ctx: OnPressedChangeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.tapExpression].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTapExpression(ctx: TapExpressionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.mapExpr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMapExpr(ctx: MapExprContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.filterExpr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFilterExpr(ctx: FilterExprContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.lambdaParams].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLambdaParams(ctx: LambdaParamsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.flowRowAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFlowRowAttr(ctx: FlowRowAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.maxLinesCount].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMaxLinesCount(ctx: MaxLinesCountContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.horizontalSpacing].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitHorizontalSpacing(ctx: HorizontalSpacingContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.verticalSpacing].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitVerticalSpacing(ctx: VerticalSpacingContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textNode].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextNode(ctx: TextNodeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextAttr(ctx: TextAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.text].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitText(ctx: TextContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textConfig].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextConfig(ctx: TextConfigContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.configAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitConfigAttr(ctx: ConfigAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fontSize].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFontSize(ctx: FontSizeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fontStyle].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFontStyle(ctx: FontStyleContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.fontStyleValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFontStyleValue(ctx: FontStyleValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.isUnderline].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIsUnderline(ctx: IsUnderlineContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.isStrikeThrough].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIsStrikeThrough(ctx: IsStrikeThroughContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.align].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAlign(ctx: AlignContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.alignValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAlignValue(ctx: AlignValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.overflow].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitOverflow(ctx: OverflowContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.overflowValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitOverflowValue(ctx: OverflowValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.maxLines].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMaxLines(ctx: MaxLinesContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.lineHeight].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLineHeight(ctx: LineHeightContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.letterSpacing].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLetterSpacing(ctx: LetterSpacingContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.imageNode].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitImageNode(ctx: ImageNodeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.imageAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitImageAttr(ctx: ImageAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.source].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSource(ctx: SourceContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.placeholder].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitPlaceholder(ctx: PlaceholderContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.placeholderTint].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitPlaceholderTint(ctx: PlaceholderTintContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.tint].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTint(ctx: TintContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.resizeMode].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitResizeMode(ctx: ResizeModeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.resizeModeValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitResizeModeValue(ctx: ResizeModeValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.animateChanges].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAnimateChanges(ctx: AnimateChangesContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.animateChangesValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAnimateChangesValue(ctx: AnimateChangesValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textFieldNode].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextFieldNode(ctx: TextFieldNodeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textFieldAttr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextFieldAttr(ctx: TextFieldAttrContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.textFieldConfig].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTextFieldConfig(ctx: TextFieldConfigContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.keyboardOptions].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitKeyboardOptions(ctx: KeyboardOptionsContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.keyboardOptionsValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitKeyboardOptionsValue(ctx: KeyboardOptionsValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.capitalization].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCapitalization(ctx: CapitalizationContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.capitalizationValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCapitalizationValue(ctx: CapitalizationValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.autoCorrect].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAutoCorrect(ctx: AutoCorrectContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.keyboardType].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitKeyboardType(ctx: KeyboardTypeContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.keyboardTypeValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitKeyboardTypeValue(ctx: KeyboardTypeValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.imeAction].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitImeAction(ctx: ImeActionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.imeActionValue].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitImeActionValue(ctx: ImeActionValueContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.inputAccessoryAction].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitInputAccessoryAction(ctx: InputAccessoryActionContext?): T

    /**
     * Visit a parse tree produced by [DSLGrammarParser.isMultiline].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIsMultiline(ctx: IsMultilineContext?): T
}