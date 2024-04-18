package types.expressions

sealed class Const(open val value: Any) : ValueExpression {
    data class BooleanConst(override val value: Boolean) : Const(value)
    data class IntConst(override val value: Int) : Const(value)
    data class DoubleConst(override val value: Double) : Const(value)
    data class StringConst(override val value: String) : Const(value)
}