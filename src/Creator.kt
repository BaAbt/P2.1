import java.util.*

fun createMusikverwaltung(songlistLaenge: Int = 20):Musikverwaltung {
    val musikverwaltung = Musikverwaltung()
    val song = arrayListOf<Song>()
    for (i in 0..songlistLaenge) {
        song.add(Song(getTitel(), getInterpret(), getTime(), getBewertung(),SongBewComp()))
    }
    song.forEach { musikverwaltung.hinzufuegen(it) }
    return musikverwaltung
}



fun getTitel():String{
    val titel = arrayListOf<String>("Theo und die sieben Zwerge","Holde Main","Krähen sind Überflieger","Rettet die Elefanten","Die Schlacht der Bastarde und Tagaryans", "Die blaue Hochzeit", "Winter is coming to town", "Das Lied von Schnee und kohle", "der eiserne Plasikstuhl","Kneelers are bad", "Ich brenne für die Kirche","Ich wollte Elefanten","gelber Schnee","forgesex","boatsex","was ich alles für die liebe mache","Gräfen und Gräfinnen","Ich mag Katzen","Assasine Podrick","You had one job","Podrick Lieblingslied","Ghost in the town","Du weißt nichts","im Westen liegt Essos","Stühle verrücken","Glockentrauma")
    return titel[Random().nextInt(titel.size)]
}
fun getInterpret():String{
    val interpret = arrayListOf<String>("der Hügel","Theo mit dem langen Wurm", "Bran Sehnichts", "Freefolk","John Gelbschnee","Ce Ce","Arhüüha","Der Hügel", "Hugo","Put Put Rick", "no One","Rick and Morty","Hooooooooodoooooooor","Patrick","Nett Stark","Wassertrinker Tyrion","Dieser komische Sänger","Wildlingsbraut","Riese Hugo","Frauenschwarm Tormund","Dem Pferd in s8ep5, das einfach nur rumstand","Professor Drogon", "Brexit Sansa","König Brad, der verkrüppelte Rollstuhlfahrer")
    return interpret[Random().nextInt(interpret.size)]
}
fun getTime():Int = Random().nextInt(300)+60

fun getBewertung():Int = Random().nextInt(100)

fun getText() = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"

fun getRandomSong() = Song(getTitel(),getInterpret(),getTime(),getBewertung(),SongBewComp())



