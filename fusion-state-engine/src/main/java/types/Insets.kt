package types
/**
 * The inset distances for views.
 *
 * Used to describe paddings or margins.
 */
data class Insets(
    /**
     * The left edge inset value.
     */
    var left: Dimension.Exact? = null,

    /**
     * The top edge inset value.
     */
    var top: Dimension.Exact? = null,

    /**
     * The right edge inset value.
     */
    var right: Dimension.Exact? = null,

    /**
     * The bottom edge inset value.
     */
    var bottom: Dimension.Exact? = null,
)