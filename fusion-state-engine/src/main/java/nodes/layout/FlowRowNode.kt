package nodes.layout

import attributes.FlowRowAttributes
import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes
import nodes.Node

data class FlowRowNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    val flowRowAttributes: FlowRowAttributes,
    override val children: MutableList<Node>,
) : LayoutNode()