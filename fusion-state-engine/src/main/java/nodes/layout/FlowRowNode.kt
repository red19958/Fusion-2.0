package nodes.layout

import attributes.FlowRowAttributes
import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes
import nodes.Node

data class FlowRowNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val tapAttributes: TapAttributes,
    val flowRowAttributes: FlowRowAttributes,
    override val children: MutableList<Node>,
) : LayoutNode()