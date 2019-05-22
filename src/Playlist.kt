import java.util.ArrayList

class Playlist(val songliste: ArrayList<Song>){
    fun gesamtdauer(): Int{
       return songliste.sumBy { it.spieldauer }
    }
    fun spieleAlle(){
        songliste.forEach { it.abspielen() }
    }
}