fun main(){
    Creator.changComperator(SongTitleComp())
    val tree = SongTreeContainer()
    repeat(10) {
        tree.addSorted(Creator.getRandomSong())
    }
    println(tree)
    readLine()
    println("size: ${tree.size()}")
    println("height: ${tree.height()}")
    println("spieldauer: ${tree.spieldauer() } ")
    println("Sumby Bewertung: ${tree.sumBy { it.bewertung }}")
    println("Charakter zum Testen:")
    val c: String = readLine()?:"A"
    println("Anzahl der Songs, die mit $c starten: ${tree.size { it.titel.startsWith(c) }}")
    readLine()
    println(("testing for each"))
    tree.forEachSong { println("aktueller Song: $it") }
    readLine()
    println("clearing song")
    tree.clear()
    println(tree)
    readLine()
    println("füge Int.MaxValue songs hinzue")
    repeat(20000){
        println("$it / ${200000}")
        tree.addSorted(Creator.getRandomSong())
    }
    println("\n\nfinnished")
    readLine()
    println("size: ${tree.size()}")
    println("height: ${tree.height()}")
    println("spieldauer: ${tree.spieldauer() } }}")
}

