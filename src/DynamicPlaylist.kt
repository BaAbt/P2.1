import java.util.ArrayList

class DynamicPlaylist(songliste: ArrayList<Song>): Playlist(songliste) {
    init{
        songliste.forEach{addSong(it)}
    }
    private var first: SongNode? = null
    private var last: SongNode? = null

    fun addSong (s: Song){
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
        first= null
        songliste.forEach{addSong(it)}
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
}