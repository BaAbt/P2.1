import java.awt.print.Printable

/*
Versuch eine generische ANode - Struktur zu bauen.
Generische Klassen sind von Natur aus invariant. Erklärung von invariant:

Nehmen wir an Klasse B ist ein Subtyp von Klasse A
Ein dataNode<B> würde normalerweise nicht von ANode<A> erben
Dummerweise brauchen wir genau das wenn wir das Objekt Emptynode<Nothing>
von der ANode<z.B. Int> klassse erben wollen. (Nothing ist ein Subtype von jeden nicht-nullable Typ)


Deswegen verwenden wir <out E>, dadurch wird dieser covariant (gegenteil von invariant)
out besagt, dass der Typ nur ausgegeben werden kann -> wir können keine objekte in einer Funktion hinzufügen sondern nur ausgebn.
Interessiert uns aber nicht, da wir ja in unseren Datanode auf links und rechts zeigen und die ändern können.
dadurch können wir Elemente zuführen, löschen, suchen, usw.
 */


sealed class ANode<out E>

internal object EmptyNode: ANode<Nothing>()

data class DataNode<E>(
    val data: E,
    var left:ANode<E> = EmptyNode,
    var right:ANode<E> = EmptyNode
):ANode<E>()







//gibt einen DataNode mit dem eingefügten DataNode zurück
fun<E: Comparable<E>> add(node: ANode<E>, data: E):DataNode<E> = when (node) {
    !is DataNode -> DataNode(data)
    else -> {
        if (data < node.data)
            node.left = add(node.left, data)
        else
            node.right =add(node.right, data)
        node
    }
}

//gibt die Anzahl aller Knoten zurück
fun<E> ANode<E>.size():Int = when(this){
    is DataNode -> this.left.size() + this.right.size() + 1
    else -> 0
}

fun<E: Comparable<E>> search(node: ANode<E>,data: E):ANode<E> = when(node){
    is EmptyNode -> node
    is DataNode<E> -> when{
        data < node.data -> search(node.left,data)
        data > node.data -> search(node.right,data)
        else -> node
    }
}

fun<E> ANode<E>.size (cond : (element:E) -> Boolean): Int = when(this){
    !is DataNode<E> -> 0
    else -> this.left.size(cond) + right.size(cond) +
            if(cond(this.data)) 1 else 0
}






fun <E> ANode<E>.forEach(f : (element : E) -> Unit){
    if (this !is DataNode) return
    this.left.forEach(f)
    f(this.data)
    this.right.forEach(f)
}

fun <E> ANode<E>.sumBy(selector: (E) -> Int):Int{
    if(this !is DataNode) return 0
    return selector(this.data) + this.left.sumBy(selector)+ this.right.sumBy(selector)
}


//TODO funktioniert im moment nicht, fixen
fun <E> ANode<E>.height(currentHeight: Int): Int {
    if(this !is DataNode) return 0
    return if (left.height(currentHeight + 1) > right.height(currentHeight + 1))
        left.height(currentHeight + 1)
    else
        right.height(currentHeight + 1)
}

//schaut, ob ein Baum vom COMPARABELN typ E data vom Element E enthält.
fun <E: Comparable<E>> ANode<E>.contains( data:E) : Boolean = when(this){
    is EmptyNode -> false
    is DataNode<E> -> when{
        data < this.data -> this.left.contains(data)
        data > this.data -> this.right.contains(data)
        else -> true
    }
}


fun <E>ANode<E>.painting(level: Int = 0):String {
    var s: String = ""
    repeat(times = level){ s += "\t"  }
    s += when(this){
        !is DataNode -> "-\n"
        else -> "${this.data}\n"+
                this.left.painting(level +1)+
                "${this.right.painting(level +1) } \n"
    }
    return s
}



