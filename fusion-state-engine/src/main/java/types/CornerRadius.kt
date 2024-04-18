package types

/**
 * Corner radii used for fusion views and backgrounds
 */
data class CornersRadius(

    /**
     * Left top corner radius
     */
    var leftTop: Dimension.Exact? = null,

    /**
     * Right top corner radius
     */
    var rightTop: Dimension.Exact? = null,

    /**
     * Left bottom corner radius
     */
    var leftBottom: Dimension.Exact? = null,

    /**
     * Right bottom corner radius
     */
    var rightBottom: Dimension.Exact? = null,
)