class SongTitleComp:Comparator<Song>{
    override fun compare(o1: Song, o2: Song): Int =
        (o1.titel.toLowerCase().compareTo(o2.titel.toLowerCase()))
}
class SongBewComp:Comparator<Song>{
    override fun compare(o1: Song, o2: Song): Int =
        (o1.bewertung-o2.bewertung)
}
