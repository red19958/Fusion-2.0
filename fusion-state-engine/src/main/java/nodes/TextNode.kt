package nodes

import attributes.TextAttributes
import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes

data class TextNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    val textAttributes: TextAttributes,
) : Node()