import java.util.*
//BonusAufgabe Übung 2

class Wiedergabe(private var aktPlay: Playlist, private var aktMod:Modus){

    fun changePlay(tempP:Playlist)   { aktPlay=tempP }
    fun changeModus(tempM:Modus)    { aktMod=tempM  }
    fun playNextSong(){
        println(currentSong)
        nextSong(aktMod, aktPlay)?.abspielen()
    }

    fun playNextSongs(a:Int){
       for(i in 0..a){
          playNextSong()
       }
    }

    fun startStopResart(){
        playNextSong()
        currentSong = 0
        playNextSong()
    }

    companion object{
        var currentSong =0
        fun nextSong(aktMod: Modus,aktPlay: Playlist): Song? {
            return when(aktMod){
                Modus.EinfacheWied -> {
                    if (aktPlay.returnSongAtIndex(currentSong)!=null){
                       return aktPlay.returnSongAtIndex(currentSong ++)
                    }
                    null
                }
                Modus.EndloseWied -> {
                    if (aktPlay.returnSongAtIndex(currentSong) != null) {
                        currentSong++
                    } else {
                        currentSong = 0
                    }
                    aktPlay.returnSongAtIndex(currentSong)
                }
                Modus.ZufallWied -> {
                    currentSong = Random().nextInt(aktPlay.songliste.size)
                    aktPlay.returnSongAtIndex(currentSong)
                }
            }
        }
    }


    //enum Klass um Modus festzustellen
    enum class Modus{
        EinfacheWied,
        EndloseWied,
        ZufallWied
    }


}