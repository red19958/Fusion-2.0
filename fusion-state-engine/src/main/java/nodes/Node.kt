package nodes

import attributes.base.LayoutAttributes
import attributes.base.ViewAttributes

abstract class Node {
    abstract val viewAttributes: ViewAttributes
    abstract val layoutAttributes: LayoutAttributes
}