package nodes.layout

import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes
import nodes.Node

class LazyColumnNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val children: MutableList<Node>,
) : LazyListNode()