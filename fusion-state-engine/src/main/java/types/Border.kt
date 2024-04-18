package types

data class Border(
    var width: Dimension.Exact? = null,
    var color: String? = null,
    var dashSize: Dimension.Exact? = null,
    var dashGap: Dimension.Exact? = null,
)