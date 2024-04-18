package nodes.layout

import nodes.Node

abstract class LayoutNode: Node() {
    abstract val children: MutableList<Node>
}