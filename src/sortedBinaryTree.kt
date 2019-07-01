import java.util.*
import kotlin.Comparator

class SortedBinaryTree<E>: Iterable<E>{

    var root:DataNode<E> = EmptyDataNode()

    fun addsorted(data:E,comp: Comparator<E>){
        if(root is EmptyDataNode)
            root = FullDataNode(data)
        else
            root.addSorted(data,comp)
    }
    fun size() = root.size()

    override fun iterator(): Iterator<E> = ElementIterator()
    inner class ElementIterator: Iterator<E>{
        private val stack: Stack<FullDataNode<E>> = Stack()
        init {
            pushToLeft(root)
        }

        private fun pushToLeft(node:DataNode<E>){
            if(node is  FullDataNode) {
                stack.push(node)
                pushToLeft(node.left)
            }
        }
        override fun hasNext(): Boolean {
            return !stack.empty()
        }
        override fun next(): E {
            val node:FullDataNode<E> = stack.pop()
            pushToLeft(node.right)
            return node.data
        }

    }
}


//warum nicht emptyDataNode in die DataNode Klasse???
sealed class DataNode<E>{
    abstract fun size(): Int
    abstract fun contains(value: Int): Boolean
    abstract fun processAllInOrder()
    abstract fun forEach( f: (e:E) -> Unit)
    abstract fun addSorted(value: E, comp: Comparator<E>)
    abstract fun paintTree(level: Int=-1)
    abstract fun getFirst():DataNode<E>

}
class EmptyDataNode<E>: DataNode<E>() {

    override fun getFirst(): DataNode<E> = this

    override fun paintTree(level: Int) {
        for(i in 0..level)
            print("\t")
        print("EmptyDataNode")
        println()
    }

    override fun addSorted(value: E, comp: Comparator<E>) {}

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

    override fun getFirst(): DataNode<E> {
        if(left !is EmptyDataNode)
            return left.getFirst()
        return this
    }

    override fun paintTree(level:Int) {
        for(i in 0..level)
            print("\t")
        print(data)
        println()
        left.paintTree(level+1)
        right.paintTree(level+1)
        println()
    }

    override fun forEach(f: (e: E) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var left : DataNode<E> = EmptyDataNode()
    var right: DataNode<E> = EmptyDataNode()


    override fun size() = left.size() + right.size() + 1


    override fun contains(value: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSorted(value: E, comp: Comparator<E>) {
        if (comp.compare(value, data)< 0) {
            if(left is EmptyDataNode)
                left = FullDataNode(value)
            else
                left.addSorted(value,comp)
        }
        else {
            if (right is EmptyDataNode)
                right = FullDataNode(value)
            else
                right.addSorted(value, comp)
        }
    }

    override fun processAllInOrder() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}




fun main(){
    val tree = SortedBinaryTree<Song>()
    for(i in 0..5) {
        tree.addsorted(getRandomSong(),SongBewComp())
    }
    tree.root.paintTree()
    println("Size: "+tree.size())
    println("Spieldauer: " + tree.sumBy { it.spieldauer })


}


