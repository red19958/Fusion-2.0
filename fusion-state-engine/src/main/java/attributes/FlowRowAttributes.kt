package attributes

import types.Dimension

data class FlowRowAttributes(
    var maxLinesCount: Int? = null,
    var horizontalSpacing: Dimension.Exact? = null,
    var verticalSpacing: Dimension.Exact? = null
)