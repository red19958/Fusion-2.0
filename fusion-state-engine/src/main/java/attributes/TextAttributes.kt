package attributes

import types.Align
import types.Config
import types.Dimension
import types.Overflow

data class TextAttributes(
    var text: String? = null,
    var config: Config? = null,
    var align: Align? = null,
    var overflow: Overflow? = null,
    var maxLines: Int? = null,
    var lineHeight: Dimension.Exact? = null,
    var letterSpacing: Dimension.Exact? = null,
)