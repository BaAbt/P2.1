import java.util.*
import kotlin.Comparator

class SortedBinaryTree<E>: Iterable<E>{

    var root:DataNode<E> = EmptyDataNode()

    fun paintTree(){ root.paintTree()}

    fun addsorted(data:E,comp: Comparator<E>){
        if(root is EmptyDataNode)
            root = FullDataNode(data)
        else
            root.addSorted(data,comp)
    }
    fun sort(comp: Comparator<E>){
        val tempRoot:DataNode<E> = root
        root = EmptyDataNode()
        tempRoot.myForEach { addsorted(it,comp) }
    }
    fun search(sdata:E, comp: Comparator<E>):DataNode<E>{
        return root.search(sdata,comp)
    }
    fun size() = root.size()


    fun myForEach( f: (e:E) -> Unit){
        root.myForEach(f)
    }

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
    abstract fun contains(value: E): Boolean
    abstract fun myForEach(f: (e:E) -> Unit)
    abstract fun addSorted(value: E, comp: Comparator<E>)
    abstract fun paintTree(level: Int=-1)
    abstract fun getFirst():DataNode<E>
    abstract fun search(sdata: E,comp: Comparator<E>): DataNode<E>


}
class EmptyDataNode<E>: DataNode<E>() {
    override fun search(sdata: E,comp: Comparator<E>): DataNode<E> {
        return this
    }

    override fun getFirst(): DataNode<E> = this

    override fun paintTree(level: Int) {
        for(i in 0..level)
            print("\t")
        print("-")
        println()
    }

    override fun addSorted(value: E, comp: Comparator<E>) {}

    override fun myForEach(f: (e: E) -> Unit) {
    }

    override fun size() = 0


    override fun contains(value: E) = false


}

private class FullDataNode<E>(val data: E): DataNode<E>() {
    override fun search(sdata:E, comp: Comparator<E>): DataNode<E> {
        return if (comp.compare(sdata,data)<0)
            left.search(sdata,comp)
        else
            right.search(sdata, comp)
    }

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

    override fun myForEach(f: (e: E) -> Unit) {
        left.myForEach(f)
        f(data)
        right.myForEach(f)
    }

    var left : DataNode<E> = EmptyDataNode()
    var right: DataNode<E> = EmptyDataNode()


    override fun size() = left.size() + right.size() + 1


    override fun contains(value: E): Boolean {
        return (data == value || left.contains(value) || right.contains(value))
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



}




fun main(){
    val tree = SortedBinaryTree<Song>()
    for(i in 0..1000) {
        tree.addsorted(getRandomSong(),SongBewComp())
    }
    while(tree.search(getRandomSong(),SongBewComp()) !is FullDataNode){
            tree.addsorted(getRandomSong(),SongBewComp())
    }
    //tree.paintTree()
    //tree.sort(SongTitleComp())
    //tree.paintTree()
    tree.size()
    //tree.myForEach {  }
    //tree.myForEach { println(it.bewertung) }
    //println("Size: "+tree.size())
    //println("Spieldauer: " + tree.sumBy { it.spieldauer })


}


