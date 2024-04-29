package types

import types.expressions.ExpressionWithValue

data class Config(
    var color: String? = null,

    /**
     * Text font size
     */
    var fontSize: Dimension.Exact? = null,

    /**
     * Text font style
     */
    var fontStyle: FontStyle? = null,

    /**
     * Whether text should be underlined
     */
    var isUnderline: ExpressionWithValue<Boolean>? = null,

    /**
     * Whether text should have strike through
     */
    var isStrikeThrough: ExpressionWithValue<Boolean>? = null,
)
