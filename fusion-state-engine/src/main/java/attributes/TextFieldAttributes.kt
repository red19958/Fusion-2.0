package attributes

import types.Config
import types.Dimension
import types.KeyboardOptions

data class TextFieldAttributes(
    var text: String? = null,
    var config: Config? = null,
    var lineHeight: Dimension.Exact? = null,
    var letterSpacing: Dimension.Exact? = null,
    var isMultiline: Boolean = true,
    var keyboardOptions: KeyboardOptions? = null,
)