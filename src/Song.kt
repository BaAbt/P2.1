open class Song (
    val titel: String,
    val interpret: String,
    val spieldauer: Int,
    bewertung: Int
)
{
    companion object{
        const val MAX_BEW = 100
        const val MIN_BEW = 0
    }

    //setzt max und minimum auf MIN_BEW..MAX_BEW
    var bewertung: Int = MIN_BEW
        set(value) {
            field = when {
                value < MIN_BEW -> MIN_BEW
                value> MAX_BEW -> MAX_BEW
                else -> value
            }
        }

    //setzt die bewertung
    init {
        this.bewertung = bewertung
    }


    // überschreibt die toString, um alle Aspekte wiederzugeben
    override fun toString(): String {
        return("$titel von $interpret, Spieldauer: $spieldauer, Bewertung: $bewertung")
    }

    //Methode, um Minuten wiederzugeben
    fun zuMinuten() =  spieldauer/60

    //spielt für jede minute einmal die Nachricht
    open fun abspielen(){
        println(this)
        for(a in 1..this.zuMinuten()) {
            println("Spiele $titel von $interpret (Bewertung: $bewertung Punkte)")
        }
    }

    //sucht im interpret und titel
    open fun suchen(suchbegriff:String): Boolean{
        return (titel.contains(suchbegriff,true) || interpret.contains(suchbegriff,true))
    }
}

class SongMitText(
    titel: String ,
    interpret: String ,
    spieldauer: Int,
    bewertung: Int,
    val Textfeld: String
) : Song (titel,interpret,spieldauer,bewertung){

   override fun suchen(suchbegriff: String): Boolean =
       super.suchen(suchbegriff) || Textfeld.contains(suchbegriff,true)

    override fun toString(): String = (super.toString() + "\nText: ${this.Textfeld}")
}
class SongMitAutoBewertung(
    titel: String = "",
    interpret: String = "",
    spieldauer: Int,
    bewertung: Int
    ): Song(titel,interpret, spieldauer, bewertung){
    override fun abspielen(){
        bewertung++
        super.abspielen()
    }
}

//bonusaufgabe
class SongMitJahr(
    titel:String,
    interpret: String,
    spieldauer: Int,
    bewertung: Int,
    var verkaufszahl:Int,
    val erscheinungsjahr: Int
):Song(titel,interpret,spieldauer, bewertung){
    final val aktuellesJahr = 2019.0
    fun durchschnittVerkauf()= verkaufszahl/(aktuellesJahr-erscheinungsjahr+1)
}


