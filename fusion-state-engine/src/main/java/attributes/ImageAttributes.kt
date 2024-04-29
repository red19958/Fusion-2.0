package attributes

import types.AnimateChanges
import types.ResizeMode
import types.expressions.ExpressionWithValue

data class ImageAttributes(
    var source: ExpressionWithValue<String>? = null,
    var placeholder: ExpressionWithValue<String>? = null,
    var placeHolderTint: ExpressionWithValue<String>? = null,
    var tint: ExpressionWithValue<String>? = null,
    var resizeMode: ResizeMode? = null,
    var animateChanges: AnimateChanges? = null,
)
