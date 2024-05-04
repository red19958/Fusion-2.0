package nodes.layout.lazy

import attributes.base.LayoutAttributes
import attributes.base.TapAttributes
import attributes.base.ViewAttributes

data class LazyRowNode(
    override val viewAttributes: ViewAttributes,
    override val layoutAttributes: LayoutAttributes,
    override val tapAttributes: TapAttributes,
    override val children: MutableList<Parts>,
) : LazyListNode()