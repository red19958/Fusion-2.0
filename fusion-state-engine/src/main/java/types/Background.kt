package types

import types.expressions.ExpressionWithValue

data class Background(
    var border: Border? = null,
    var cornerRadius: CornersRadius? = null,
    var color: ExpressionWithValue<String>? = null,
)