
class SongTreeContainerTest {

    fun testAddSorted() {
    }

    fun testSize() {
    }

    fun testSpieldauer() {
    }

    fun testForEachSong() {
    }

    fun testSumBy() {
    }

    fun testClear() {
    }

    fun testHeight() {
    }

    fun testToString() {
    }
}
fun main(){
    val tree = SongTreeContainer()
    repeat(10) {
        tree.addSorted(getRandomSong())
    }
    println(tree)
    readLine()
    println("size: ${tree.size()}")
    println("height: ${tree.height()}")
    println("spieldauer: ${tree.spieldauer() } }}")
    readLine()
    println(("testing for each"))
    tree.forEachSong { println("aktueller Song: $it") }
    readLine()
    println("clearing song")
    tree.clear()
    println(tree)
    readLine()
    println("füge Int.MaxValue songs hinzue")
    repeat(200000){
        println("$it / ${200000}")
        tree.addSorted(getRandomSong())
    }
    println("\n\nfinnished")
    readLine()
    println("size: ${tree.size()}")
    println("height: ${tree.height()}")
    println("spieldauer: ${tree.spieldauer() } }}")
}

