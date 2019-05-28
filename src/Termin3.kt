fun termin3(){
    val musikverwaltung = createMusikverwaltung(10)
    val playlist1 = musikverwaltung.zufaelligePlaylist()
    val playlist2 = DynamicPlaylist(playlist1.songliste)

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
    val song = SongMitText(getTitel(),getInterpret(),getTime(),getBewertung(), getText())
    musikverwaltung.hinzufuegen(song)
    println(musikverwaltung.suche("Lorem ipsum"))

}