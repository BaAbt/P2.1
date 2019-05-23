import java.util.*
//BonusAufgabe Übung 2

class Wiedergabe(var aktPlay: Playlist, var aktMod:Modus){
    var a = aktPlay.songliste.size



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
                Modus.einfacheWied -> {
                    if (aktPlay.returnSongAtIndex(currentSong)!=null){
                       aktPlay.returnSongAtIndex(currentSong ++)
                    }
                    null
                }
                Modus.endloseWied -> {
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



    enum class Modus{
        einfacheWied,
        endloseWied,
        ZufallWied
    }


}