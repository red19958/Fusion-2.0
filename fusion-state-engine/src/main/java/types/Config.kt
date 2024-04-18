package types

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
    var isUnderline: Boolean? = null,

    /**
     * Whether text should have strike through
     */
    var isStrikeThrough: Boolean? = null,
)
