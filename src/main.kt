
fun main() {

    //erstelle eine playlist mit den ersten drei songs und eine zufällige
    val musikverwaltung = createMusikverwaltung()
    val playlist1 =Playlist(arrayListOf(musikverwaltung.songliste[0],musikverwaltung.songliste[1],musikverwaltung.songliste[2]))
    val playlist2 = musikverwaltung.zufaelligePlaylist()

    //Liveaufgabe
    //liveaufgabe2(playlist1, playlist2)
    //Bonusaufgabe
    //bonusaufgabe2(playlist1)


    //normales Programm
    println("Normales Programm")
    println("\n\n\nSpiele Playlist 1:\n")
    playlist1.spieleAlle()
    println("\n\n\nSpiele Playlist 2:\n")
    playlist2.spieleAlle()

    //geben besten song aus
    println("\n\nBester Song: " )
    println(musikverwaltung.besterSong())

    //suche Song
    suchen(musikverwaltung)

}
fun suchen(musikverwaltung: Musikverwaltung){
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
