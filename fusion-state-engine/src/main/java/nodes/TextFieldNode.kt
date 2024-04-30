package nodes

import attributes.TextFieldAttributes
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes

data class TextFieldNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val tapAttributes: TapAttributes,
    val textFieldAttributes: TextFieldAttributes,
) : Node()