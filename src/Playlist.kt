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
