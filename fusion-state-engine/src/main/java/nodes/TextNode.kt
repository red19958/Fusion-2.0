package nodes

import attributes.TextAttributes
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes

data class TextNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val tapAttributes: TapAttributes,
    val textAttributes: TextAttributes,
) : Node()