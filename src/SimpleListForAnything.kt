interface SimpleListForAnything {
    fun addFirst ( obj: Any)
    fun addLast(obj:Any)

    fun contains(obj: Any)

    fun isEmpty():Boolean
    fun size():Int
    fun getFirst():Any
    fun get(index: Int) : Any

    fun removeObj(obj:Any)
}