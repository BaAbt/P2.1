fun termin3(){
    //live
    println("liveaufgabe\n")
    liveaufgabe3()
    readLine()


    val musikverwaltung = Creator.createMusikverwaltung(10)
    val playlist1 = musikverwaltung.zufaelligePlaylist()
    val playlist2 = DynamicPlaylist(playlist1.songliste)

    bonusaufgabe3(playlist2)


    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()
    playlist2.getFirstSong()
    playlist2.getFirstSong()
    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()
    playlist2.reset()
    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()

    println("\n\nErstelle SongmitText")
    val song = Creator.getRandomSong()

    musikverwaltung.hinzufuegen(song)
    println(musikverwaltung.suche("Lorem ipsum"))

}