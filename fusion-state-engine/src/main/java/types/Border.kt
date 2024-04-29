package types

import types.expressions.ExpressionWithValue

data class Border(
    var width: Dimension.Exact? = null,
    var color: ExpressionWithValue<String>? = null,
    var dashSize: Dimension.Exact? = null,
    var dashGap: Dimension.Exact? = null,
)