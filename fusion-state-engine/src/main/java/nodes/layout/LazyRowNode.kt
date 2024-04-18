package nodes.layout

import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes
import nodes.Node

data class LazyRowNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val children: MutableList<Node>,
) : LazyListNode()