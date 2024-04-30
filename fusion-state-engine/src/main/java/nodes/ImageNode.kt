package nodes

import attributes.ImageAttributes
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes

data class ImageNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val tapAttributes: TapAttributes,
    val imageAttributes: ImageAttributes,
) : Node()