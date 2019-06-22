fun liveaufgabe2(playlist1:Playlist,playlist2:Playlist){

    val bew=50

    println("\nLiveaufgabe:")
    println("Playlist1 hat ${playlist1.songsMitBewertung(bew)} Songs mit der Bew $bew")
    println("Playlist2 hat ${playlist2.songsMitBewertung(bew)} Songs mit der Bew $bew")
    readLine()

}
fun liveaufgabe3(){
    val s1 = SongMitJahr(getTitel(),getInterpret(),getTime(),getBewertung(),1000000,2018)
    println(s1.durchschnittVerkauf())
}
