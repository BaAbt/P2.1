fun termin3(){
    val musikverwaltung = createMusikverwaltung(10)
    val playlist1 = musikverwaltung.zufaelligePlaylist()
    val playlist2 = DynamicPlaylist(playlist1.songliste)




    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()
    playlist2.songEntnehmen()
    playlist2.songEntnehmen()
    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()
    playlist2.zuruecksetzen()
    println("\n\nGesamtdauer: "+playlist2.gesamtdauer())
    playlist2.spieleAlle()
}