package attributes

import types.Config
import types.Dimension
import types.KeyboardOptions
import types.expressions.ExpressionWithValue

data class TextFieldAttributes(
    var text: ExpressionWithValue<String>? = null,
    var config: Config? = null,
    var lineHeight: Dimension.Exact? = null,
    var letterSpacing: Dimension.Exact? = null,
    var isMultiline: ExpressionWithValue<Boolean>? = null,
    var keyboardOptions: KeyboardOptions? = null,
)