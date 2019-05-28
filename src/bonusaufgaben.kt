fun bonusaufgabe2(playlist: Playlist) {
    println("\n\nBonusaufgabe")
    println("\narbeite mit Playlist, zeige alle\n")
    playlist.songliste.forEach { println(it) }
    readLine()
    println("\n\nErstelle Wiedergabe mit einfacher Wiedergabe und spiele 4  nächste song\n")
    val w1 = Wiedergabe(playlist, Wiedergabe.Modus.EinfacheWied)
    for (i in 0..4) {
        w1.playNextSong()
    }
    readLine()
    println("\n\nStarte neu und spiele 3 nächste songs\n")
    w1.startStopResart()
    w1.playNextSongs(3)
    readLine()
    println("\n\nSetze Modus zu endlose Playlist und spiele  6 songs\n")
    w1.changeModus(Wiedergabe.Modus.EndloseWied)
    w1.playNextSongs(6)
    readLine()
    println("\n\nSetze Modus zu Zuffalswiedergabe und spiele 2 Songs\n")
    w1.changeModus(Wiedergabe.Modus.ZufallWied)
    w1.playNextSongs(2)
    readLine()
    w1.changePlay(playlist)
}
