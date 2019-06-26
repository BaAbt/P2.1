import java.lang.Exception

class SortedBinaryTree<E>{


    fun addsorted(element: E){

    }
    fun size():Int{
        TODO("NOT IMPLEMENTED")
    }
    fun forEachSong( f: (e:E) -> Unit){
    }
}


//warum nicht emptyDataNode in die DataNode Klasse???
sealed class DataNode<E>{
    abstract fun size(): Int
    abstract fun contains(value: Int): Boolean
    abstract fun processAllInOrder()
    abstract fun forEach( f: (e:E) -> Unit)
    abstract fun addsorted(value: E, comp: Comparator<E>)
}
class EmptyDataNode<E>: DataNode<E>() {
    override fun addsorted(value: E, comp: Comparator<E>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forEach(f: (e: E) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun size() = 0


    override fun contains(value: Int) = false


    override fun processAllInOrder() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

private class FullDataNode<E>(val data: E): DataNode<E>() {
    override fun forEach(f: (e: E) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var left : DataNode<E> = EmptyDataNode()
    var right: DataNode<E> = EmptyDataNode()


    override fun size() = left.size() + right.size() + 1


    override fun contains(value: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addsorted(value: E, comp: Comparator<E>) {
        if (comp.compare(value, data)< 0) {
            if(left is EmptyDataNode)
                left = FullDataNode(value)
            else
                left.addsorted(value,comp)
        }
        else {
            if (right is EmptyDataNode)
                right = FullDataNode(value)
            else
                right.addsorted(value, comp)
        }
    }


    override fun processAllInOrder() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

class SongComp:Comparator<Song>{
    override fun compare(o1: Song, o2: Song): Int {
        return(o1.titel.toLowerCase().compareTo(o2.titel.toLowerCase()))
    }
}

fun main(){
    val a = getXSongs(10)
    val root = FullDataNode<Song>(a[0])
    a.forEach { root.addsorted(it, SongComp()) }


}

