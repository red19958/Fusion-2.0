package types.expressions

data class ExpressionWithValue<T : Any>(
    var expression: AttrExpressionType? = null,
    var value: T? = null,
)
