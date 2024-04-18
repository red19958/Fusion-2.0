package attributes.base

import types.Dimension
import types.Gravity
import types.Insets

data class LayoutAttributes(
    var width: Dimension? = null,
    var height: Dimension? = null,
    var weight: Double? = null,
    var gravity: Gravity? = null,
    var margin: Insets? = null,
)