package attributes.base

import types.expressions.TapExpression

data class TapAttributes(
    val onTap: List<TapExpression>? = null,
    val onLongTap: List<TapExpression>? = null,
)
