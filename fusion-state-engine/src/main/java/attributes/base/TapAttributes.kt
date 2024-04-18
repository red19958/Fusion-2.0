package attributes.base

import types.expressions.TapExpressions

data class TapAttributes(
    val onTap: TapExpressions? = null,
    val onLongTap: TapExpressions? = null,
    val onPressedChange: TapExpressions? = null,
)
