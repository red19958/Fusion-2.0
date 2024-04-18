package types

sealed interface Color {
    fun isTransparent(): Boolean = false

    /**
     * Fallback for views which support only [Solid] color.
     */
    fun asSolid(): Long

    data class Solid(
        val color: Long,
    ) : Color {
        override fun asSolid(): Long = color
        override fun isTransparent(): Boolean = color == TRANSPARENT
    }

    sealed interface Gradient : Color {
        data class Linear(
            val start: GradientPoint,
            val end: GradientPoint,
        ) : Gradient {
            override fun asSolid(): Long = start.color
        }
    }

    companion object {
        private const val TRANSPARENT = 0L
    }
}

data class GradientPoint(val x: Double, val y: Double, val color: Long)