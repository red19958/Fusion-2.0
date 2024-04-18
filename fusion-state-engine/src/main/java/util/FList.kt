package util

data class FList<T : Any>(val list: MutableList<T> = mutableListOf()) : MutableList<T> by list {
    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }
}