import java.util.ArrayList

open class Playlist(val songliste: ArrayList<Song>){

    //returns gesamtdauer
    open fun gesamtdauer(): Int{
        return songliste.sumBy { it.spieldauer }
    }

    //spiele alle lieder ab
    open fun spieleAlle(){
        songliste.forEach { it.abspielen() }
    }

    //gibt die anzahl der lieder mit minimaler score an
    fun songsMitBewertung(a:Int):Int{
        var anzahl = 0
        songliste.forEach { if(it.bewertung>a)anzahl++  }
        return anzahl
    }

    //Bonusaufgabe
    fun returnSongAtIndex(a: Int): Song? {
        if(a in 0 until songliste.size)
            return songliste[a]
        else
            return null

    }
}
class DynamicPlaylist(songliste: ArrayList<Song>): Playlist(songliste) {
    init{
        songliste.forEach{songHinzufuegen(it)}
    }
    private var first: SongNode? = null
    private var last: SongNode? = null

    fun songHinzufuegen (s: Song){
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
    fun songEntnehmen(){
        if(first == null){
            println("Entnehmen gescheitert, liste ist leer")
        }else{
            println("\nEntnehme Song\n")
            first = first!!.nextSong
        }
    }

    //setzt die playlist zurück
    fun zuruecksetzen(){
        first= null
        songliste.forEach{songHinzufuegen(it)}
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
    inner class SongNode(var nextSong:SongNode?, var song:Song)
}