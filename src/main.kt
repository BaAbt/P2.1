import java.util.Random

fun main() {
    val musikverwaltung = Musikverwaltung()
    val song = arrayListOf<Song>()
    val songlistLaenge = 20
    for(i in 0..songlistLaenge){
       song.add(Song(getTitel(), getInterpret() ,getTime(), getBewertugn()))
    }
    song.forEach { musikverwaltung.hinzufuegen(it) }

    //erstelle eine playlist mit den ersten drei songs und eine zufällige
    val playlist1 = Playlist(arrayListOf(song[0],song[1],song[2]))
    val playlist2 = musikverwaltung.zufaelligePlaylist()
    println("\n\n\nSpiele Playlist 1:\n")
    playlist1.spieleAlle()
    println("\n\n\nSpiele Playlist 2:\n")
    playlist2.spieleAlle()

    //geben besten song aus
    println("\n\nBester Song: " )
    println(musikverwaltung.besterSong())

    //suche nach wert, bis stopp eingegeben wird
    do {
        println("\n\nBitte Suchbegriff eingeben, 'stopp' beendet die Suche")
        println("\nEingabe: ")
        val eingabe:String = readLine().toString()
        if(eingabe.toLowerCase() == "stopp") {
            break
        }
        musikverwaltung.suche(eingabe).abspielen()
    }while (true)
}



fun getTitel():String{
    val titel = arrayListOf<String>("Theo und die sieben Zwerge","Holde Main","Krähen sind Überflieger","Rettet die Elefanten","Die Schlacht der Bastarde und Tagaryans", "Die blaue Hochzeit", "Winter is coming to town", "Das Lied von Schnee und kohle", "der eiserne Plasikstuhl","Kneelers are bad", "Ich brenne für die Kirche","Ich wollte Elefanten","gelber Schnee","forgesex","boatsex","was ich alles für die liebe mache","Gräfen und Gräfinnen","Ich mag Katzen","Assasine Podrick","You had one job","Podrick Lieblingslied","Ghost in the town","Du weißt nichts","im Westen liegt Essos","Stühle verrücken","Glockentrauma")
    return titel[Random().nextInt(titel.size)]
}
fun getInterpret():String{
    val interpret = arrayListOf<String>("der Hügel","Theo mit dem langen Wurm", "Bran Sehnichts", "Freefolk","John Gelbschnee","Ce Ce","Arhüüha","Der Hügel", "Hugo","Put Put Rick", "no One","Rick and Morty","Hooooooooodoooooooor","Patrick","Nett Stark","Wassertrinker Tyrion","Dieser komische Sänger","Wildlingsbraut","Riese Hugo","Frauenschwarm Tormund","Dem Pferd is s8ep5, das einfach nur rumstand","Professor Drogon", "Brexit Sansa","König Brad, der verkrüppelte Rollstuhlfahrer")
    return interpret[Random().nextInt(interpret.size)]
}
fun getTime():Int = Random().nextInt(300)

fun getBewertugn():Int = Random().nextInt(100)

