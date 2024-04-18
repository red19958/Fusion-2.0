package types

sealed class Dimension {
    sealed class Exact : Dimension() {
        abstract val doubleValue: Double

        data class NativePoints(override val doubleValue: Double) : Exact() {
            override fun toString(): String = "$doubleValue$NP"
        }

        data class AdaptivePoints(override val doubleValue: Double) : Exact() {
            override fun toString(): String = "$doubleValue$AP"
        }
    }

    /**
     * Represents view dimension value that depends on some other dimension value
     */
    sealed class Match : Dimension() {
        /**
         * View wants to be just large enough to fit its own internal content,
         * taking its own padding into account
         */
        object Wrap : Match() {
            override fun toString(): String = "wrap"
        }

        /**
         * View wants to be as big as its parent, minus the parent's padding, if any
         */
        object Fill : Match() {
            override fun toString(): String = "fill"
        }
    }

    internal companion object {
        private const val NP = "np"
        private const val AP = "ap"
    }
}