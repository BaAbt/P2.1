fun liveaufgabe3(){
    val s1 = SongMitJahr(Creator.getTitel(),Creator.getInterpret(),Creator.getTime(),Creator.getBewertung(),1000000,2018,SongBewComp())
    println(s1.durchschnittVerkauf())
}
