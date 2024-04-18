package nodes

import attributes.TextFieldAttributes
import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes

data class TextFieldNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    val textFieldAttributes: TextFieldAttributes,
) : Node()