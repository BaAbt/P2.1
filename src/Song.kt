class Song (
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
    fun abspielen(){
        for(a in 1..this.zuMinuten()) {
            println("Spiele $titel von $interpret (Bewertung: $bewertung Punkte)")
        }
    }

    //sucht im interpret und titel
    fun suchen(suchbegriff:String): Boolean=
        (titel.contains(suchbegriff,true) || interpret.contains(suchbegriff,true))
}