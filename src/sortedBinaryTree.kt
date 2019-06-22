interface SortedBinaryTree<E>{
    fun addsorted(element: E){

    }
    fun size():Int{
        TODO("NOT IMPLEMENTED")
    }
    fun forEachSong( f: (e:E) -> Unit){
    }
}


//warum nicht emptyDataNode in die DataNode Klasse???
interface DataNode{
    abstract  fun addsorted()
}
class emptyDataNode(): DataNode {
    override fun addsorted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class fullDataNode(): DataNode {
    override fun addsorted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

