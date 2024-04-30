package types.expressions

sealed interface AttrExpressionType {
    data class IfThen(
        val condition: Condition,
        val trueValue: ValueExpression,
        val falseValue: ValueExpression? = null,
    ) : AttrExpressionType

    data class FieldExpr(
        val name: String,
        val get: GetExpression? = null,
    ) : AttrExpressionType, ValueExpression
}