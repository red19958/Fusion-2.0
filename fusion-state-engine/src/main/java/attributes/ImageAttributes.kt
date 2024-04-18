package attributes

import types.AnimateChanges
import types.ResizeMode

data class ImageAttributes(
    var source: String? = null,
    var placeholder: String? = null,
    var placeHolderTint: String? = null,
    var tint: String? = null,
    var resizeMode: ResizeMode? = null,
    var animateChanges: AnimateChanges? = null,
)
