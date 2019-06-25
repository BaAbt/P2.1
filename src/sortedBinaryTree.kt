/*class SortedBinaryTree<E>{
    var root = EmptyDataNode


    fun addsorted(element: E){
        root.addsorted()

    }
    fun size():Int{
        TODO("NOT IMPLEMENTED")
    }
    fun forEachSong( f: (e:E) -> Unit){
    }
}


//warum nicht emptyDataNode in die DataNode Klasse???
sealed class DataNode<E>{
    abstract fun size();
    abstract fun suum()
    abstract fun contains(value: Int): Boolean
    abstract fun addsorted(value: E)

    abstract fun processAllInOrder()

}
object EmptyDataNode: DataNode() {

}

private class fullDataNode(): DataNode() {
    override fun addsorted(input: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}*/
fun main(){
    lamdatest { println(it) }
}

fun lamdatest( f: (a:Int)-> Unit){
    f(5)
}

fun add(a:Int,b:Int) = a+b

