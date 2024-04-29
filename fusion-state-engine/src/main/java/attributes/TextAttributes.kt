package attributes

import types.Align
import types.Config
import types.Dimension
import types.Overflow
import types.expressions.ExpressionWithValue

data class TextAttributes(
    var text: ExpressionWithValue<String>? = null,
    var config: Config? = null,
    var align: Align? = null,
    var overflow: Overflow? = null,
    var maxLines: ExpressionWithValue<Int>? = null,
    var lineHeight: Dimension.Exact? = null,
    var letterSpacing: Dimension.Exact? = null,
)