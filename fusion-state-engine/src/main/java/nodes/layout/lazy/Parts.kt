package nodes.layout.lazy

import nodes.Node
import types.expressions.ExpressionWithValue

sealed interface Parts {
    data class Items(val size: ExpressionWithValue<Int>, val child: Node) : Parts

    data class Item(val child: Node) : Parts
}