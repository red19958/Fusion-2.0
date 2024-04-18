package types.expressions

data class Condition(
    var firstArg: Const,
    var equals: Boolean? = null,
    var secondArg: AttrExpressionType.FieldExpr? = null,
)
