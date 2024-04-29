package attributes

import types.Dimension
import types.expressions.ExpressionWithValue

data class FlowRowAttributes(
    var maxLinesCount: ExpressionWithValue<Int>? = null,
    var horizontalSpacing: Dimension.Exact? = null,
    var verticalSpacing: Dimension.Exact? = null
)