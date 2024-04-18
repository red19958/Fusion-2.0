package types.expressions

sealed interface TapExpressionType {
    data class MapExpr(
        val condition: Condition? = null,
        val trueValue: Any? = null,
        val falseValue: Any? = null,
    ) : TapExpressionType // заглушка

    data class FilterExpr(
        val name: String? = null,
    ) : TapExpressionType // заглушка
}