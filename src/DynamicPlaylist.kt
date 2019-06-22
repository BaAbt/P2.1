import java.util.ArrayList

class DynamicPlaylist(songliste: ArrayList<Song>): Playlist(songliste), Iterable<Song>{

    private var first: SongNode? = null
    private var last: SongNode? = null

    init{
        createDynList(songliste)
    }

    private fun createDynList(list:ArrayList<Song>){
        first = null
        list.forEach{addSong(it)}
        println("\n")
    }

    private fun addSong (s: Song){
        if (first == null){
            val newSongNode =SongNode(null,s)
            first = newSongNode
            last = newSongNode
            println("\n\nInit:\nerster Song Hinzugefügt: "+ newSongNode.song)
        }else{
            val newSongNode = SongNode(null,s)
            last?.nextSong = newSongNode
            last = newSongNode
            println("Hinzugefügt: "+ newSongNode.song)
        }
    }


    //entnimmt den ersten song
    fun getFirstSong(){
        if(first == null){
            println("Entnehmen gescheitert, liste ist leer")
        }else{
            println("\nEntnehme Song\n")
            first = first?.nextSong
        }
    }

    //setzt die playlist zurück
    fun reset(){
        createDynList(songliste)
    }

    //gibt die gesamtdauer an
    override fun gesamtdauer(): Int{
        var i:SongNode? = first
        var a =0
        while (i != null){
            a+=i.song.spieldauer
            i=i.nextSong
        }
        return a
    }
    override fun spieleAlle() {
        println("\n\nspiele alle Songs ab: \n\n")
        var i:SongNode? = first
        while (i != null){
            i.song.abspielen()
            i=i.nextSong
        }
    }
    inner class SongNode(var nextSong:SongNode?, var song: Song)


    override fun iterator(): Iterator<Song> {
        return object: Iterator<Song> {
            private var run = first
            override fun hasNext(): Boolean {
                return (run?.nextSong != null)
            }
            override fun next(): Song {
                val temp = run?.song ?: throw NoSuchElementException()
                run = run?.nextSong ?: throw NoSuchElementException()
                return temp
            }
        }
    }






    //bonusaufgabe
    fun getAllSongs():ArrayList<Song>{
        val list = arrayListOf<Song>()
        var i:SongNode? = first
        while(i!= null){
            list.add(i.song)
            i = i.nextSong
        }
        return list
    }

    fun myPlayAll(){
        getAllSongs().forEach { println(it) }
    }

    fun addSorted(song: Song, comp:Comparator<Song>){
        addSong(song)
        val templist = getAllSongs()
        templist.sortWith(comp)
        createDynList(templist)
    }
}

class SortByBew(): Comparator<Song>{
    override fun compare(p0: Song?, p1: Song?): Int {
        return (p0?.bewertung ?: 0) - (p1?.bewertung ?: 0)
    }
}
class SortByName(): Comparator<Song>{
    override fun compare(p0: Song?, p1: Song?): Int {
        return (p0?.titel?.compareTo(p1?.titel?:"")?: 0)
    }
}
