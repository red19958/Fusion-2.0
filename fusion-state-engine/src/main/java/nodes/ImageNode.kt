package nodes

import attributes.ImageAttributes
import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes

data class ImageNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    val imageAttributes: ImageAttributes,
) : Node()