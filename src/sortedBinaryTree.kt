import java.util.*
import kotlin.Comparator


class SortedBinaryTree<E>: Iterable<E>{

    var root: Node<E> = EmptyNode

    fun paintTree(){ root.paintTree()}

    fun addsorted(data:E,comp: Comparator<E>){
        if(root is EmptyNode)
            root = DataNode(data)
        else
            root.addSorted(data,comp)
    }

    fun officiallyAddSorted(data: E,comp:Comparator<E>){
        root = root.officialAddSorted(data,comp)
    }

    fun sort(comp: Comparator<E>){
        val tempRoot: Node<E> = root
        root = EmptyNode()
        tempRoot.myForEach { addsorted(it,comp) }
    }
    fun search(sdata:E, comp: Comparator<E>): Node<E> {
        return root.search(sdata,comp)
    }
    fun size() = root.size()

    fun height() = root.height()


    fun myForEach( f: (e:E) -> Unit){
        root.myForEach(f)
    }

    override fun iterator(): Iterator<E> = ElementIterator()
    inner class ElementIterator: Iterator<E>{
        private val stack: Stack<DataNode<E>> = Stack()
        init {
            pushToLeft(root)
        }

        private fun pushToLeft(node: Node<E>){
            if(node is DataNode) {
                stack.push(node)
                pushToLeft(node.left)
            }
        }
        override fun hasNext(): Boolean {
            return !stack.empty()
        }
        override fun next(): E {
            val node: Node.DataNode<E> = stack.pop()
            pushToLeft(node.right)
            return node.data
        }

    }
}


//warum nicht emptyDataNode in die Node Klasse???
sealed class Node<out E> {
    abstract fun size(): Int
    abstract fun <T:E>contains(value: T): Boolean
    abstract fun myForEach(f: (e: E) -> Unit)
    abstract fun addSorted(value: E, comp: Comparator<E>)
    abstract fun officialAddSorted(value: E, comp: Comparator<E>): DataNode<E>
    abstract fun paintTree(level: Int = -1)
    abstract fun getFirst(): Node<E>
    abstract fun search(sdata: E, comp: Comparator<E>): Node<E>
    abstract fun height(currentHeight: Int = 0): Int


    internal object EmptyNode: Node<Nothing>() {
        override fun officialAddSorted(value: Nothing, comp: Comparator<Nothing>)  = DataNode(value)

        override fun height(currentHeight: Int): Int = currentHeight

        override fun search(sdata: Nothing, comp: Comparator<Nothing>): Node<Nothing> {
            return this
        }

        override fun getFirst(): Node<Nothing> = this

        override fun paintTree(level: Int) {
            for (i in 0..level)
                print("\t")
            print("-")
            println()
        }

        override fun addSorted(value: Nothing, comp: Comparator<Nothing>) {}

        override fun myForEach(f: (e: Nothing) -> Unit) {
        }

        override fun size() = 0


        override fun contains(value: Nothing) = false
    }




    data class DataNode<E>(val data: E): Node<E>() {
        var left: Node<E> = EmptyNode
        var right: Node<E> = EmptyNode

        override fun officialAddSorted(value: E, comp: Comparator<E>): Node<E> {
            return if (comp.compare(value, data) < 0)
                left.officialAddSorted(value, comp)
            else
                right.officialAddSorted(value, comp)
        }

        override fun height(currentHeight: Int): Int =
            if (left.height(currentHeight + 1) > right.height(currentHeight + 1))
                left.height(currentHeight + 1)
            else
                right.height(currentHeight + 1)

        override fun search(sdata: E, comp: Comparator<E>): Node<E> {
            return if (comp.compare(sdata, data) < 0)
                left.search(sdata, comp)
            else
                right.search(sdata, comp)
        }

        override fun getFirst(): Node<E> {
            if (left !is EmptyNode)
                return left.getFirst()
            return this
        }

        override fun paintTree(level: Int) {
            for (i in 0..level)
                print("\t")
            print(data)
            println()
            left.paintTree(level + 1)
            right.paintTree(level + 1)
            println()
        }

        override fun myForEach(f: (e: E) -> Unit) {
            left.myForEach(f)
            f(data)
            right.myForEach(f)
        }


        override fun size() = left.size() + right.size() + 1


        override fun contains(value: E): Boolean {
            return (data == value || left.contains(value) || right.contains(value))
        }

        override fun addSorted(value: E, comp: Comparator<E>) {
            if (comp.compare(value, data) < 0) {
                if (left is EmptyNode)
                    left = DataNode(value)
                else
                    left.addSorted(value, comp)
            } else {
                if (right is EmptyNode)
                    right = DataNode(value)
                else
                    right.addSorted(value, comp)
            }
        }

    }


}




fun main(){
    val tree = SortedBinaryTree<Song>()
    val tree2 = SortedBinaryTree<Song>()
    for(i in 0..10) {
        val a = getRandomSong()
        tree.addsorted(a,SongBewComp())
        //tree2.officiallyAddSorted(a.co,SongBewComp())
    }
    tree.paintTree()
    tree2.paintTree()
    //tree.paintTree()
    //tree.sort(SongTitleComp())
    //tree.paintTree()
    //tree.myForEach {  }
    //tree.myForEach { println(it.bewertung) }
    //println("Size: "+tree.size())
    //println("Spieldauer: " + tree.sumBy { it.spieldauer })


}


