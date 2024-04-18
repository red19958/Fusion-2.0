package types.expressions

sealed interface GetExpression {
    data class IntGet(val value: Int) : GetExpression
    data class StringGet(val value: String) : GetExpression
}