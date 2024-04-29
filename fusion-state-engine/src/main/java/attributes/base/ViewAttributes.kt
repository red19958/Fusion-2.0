package attributes.base

import types.Background
import types.Insets
import types.expressions.ExpressionWithValue

data class ViewAttributes(
    var testTag: ExpressionWithValue<String>? = null,
    var alpha: ExpressionWithValue<Float>? = null,
    var padding: Insets? = null,
    var background: Background? = null,
    var isEnabled: ExpressionWithValue<Boolean>? = null,
    var isVisible: ExpressionWithValue<Boolean>? = null,
)