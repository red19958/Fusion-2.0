package nodes.layout.lazy

import nodes.Node

abstract class LazyListNode : Node() {
    abstract val children: MutableList<Parts>
}