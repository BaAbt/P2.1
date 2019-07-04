import java.util.*
import kotlin.collections.ArrayList

/**
 * Klasse Musikverwaltung, welche alle Songs, und playlist organisiert und in der man suchen kann
 **/
class Musikverwaltung{

    var songliste = arrayListOf<Song>()

    // fügt einen Song so songliste hinzu
    fun hinzufuegen(song: Song) { songliste.add(song)}

    // sucht nach dem gegebenen Begriff in der songliste
    fun suche(suchbegriff: String): Song? {
        songliste.onEach { if(it.suchen(suchbegriff))return it }
        return null
    }

    // wählt den song mit der höchsten Bewertung aus
    fun besterSong(): Song {
        return this.songliste.maxBy(Song::bewertung)!!
    }

    // erstellt eine zufällig große Playlist, welche zufällige Songs beinhaltet.
    // Die Größe der Playlist ist abhängig von der Größe der Songliste
    // Es können keine Lieder doppelt vorkommen
    fun zufaelligePlaylist(): Playlist {
        val p= ArrayList<Song>()
        for(i in 0..Random().nextInt(songliste.size)) {    p.add(songliste[i])   }
        p.shuffle()
        return Playlist(p)
    }
}