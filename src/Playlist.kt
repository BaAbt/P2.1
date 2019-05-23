import java.util.ArrayList

class Playlist(val songliste: ArrayList<Song>){
    fun gesamtdauer(): Int{
        return songliste.sumBy { it.spieldauer }
    }
    fun spieleAlle(){
        songliste.forEach { it.abspielen() }
    }
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