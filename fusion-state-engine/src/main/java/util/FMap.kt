package util

data class FMap<T : Any>(val map: MutableMap<String, T> = mutableMapOf()) :
    MutableMap<String, T> by map {
    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return map.hashCode()
    }
}