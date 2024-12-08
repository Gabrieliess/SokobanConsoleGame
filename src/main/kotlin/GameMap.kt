import kotlin.system.exitProcess

class GameMap(private val length: Int = 7, private val width: Int = 8) {

    var design = mutableListOf(
        mutableListOf('#', '#', '#', '#', '#', '#', '#', '#', '#'),
        mutableListOf('#', ' ', ' ', ' ', '#', '#', '#', '#', '#'),
        mutableListOf('#', ' ', 'B', ' ', '#', ' ', ' ', ' ', '#'),
        mutableListOf('#', ' ', ' ', ' ', '#', 'B', '#', ' ', '#'),
        mutableListOf('#', '#', '#', 'B', ' ', ' ', ' ', ' ', '#'),
        mutableListOf('#', '#', ' ', ' ', ' ', '#', '#', '#', '#'),
        mutableListOf('#', '#', ' ', 'P', '*', '*', '*', '#', '#'),
        mutableListOf('#', '#', '#', '#', '#', '#', '#', '#', '#')
    )

    fun printMap() {

        for (i in 0..<length + 1) {
            for (j in 0..<width + 1) {
                print(design[i][j])
            }
            println()
        }
    }
    fun terminateProgram() {

        println("You sure? [Y/N]")

        for (i in 0..3) {
            val input = readln()

            if (input.isEmpty()) {
                println("Bro answer..")
            } else if (input[0].lowercaseChar() == 'y') {
                exitProcess(0)
            } else if (input[0].lowercaseChar() == 'n') {
                println("Copy that")
                break
            } else if (i == 3) {
                println("Unbelievable..")
                exitProcess(0)
            } else {
                println("Bro read.. Y or N")
            }
        }
    }

    fun isGameWon(gameMap: GameMap): Boolean {
        return gameMap.design[6][4] == 'B' && gameMap.design[6][5] == 'B' && gameMap.design[6][6] == 'B'
    }

    fun gameTimer(stopTimer: Boolean): Int{

        if(!stopTimer){
            startingTime = System.currentTimeMillis()
        }
        else{
            val endingTime = System.currentTimeMillis()

            gameTime = endingTime - startingTime
        }
        return 0
    }

    fun endTheGame(amountOfMoves: Long) {
        println("*-------------------------------*")
        println("         CONGRATULATIONS         ")
        println("             YOU WON!            ")
        println("  Total moves:                   ")
        println("  $amountOfMoves                 ")
        println("                                 ")
        println("  Total time:                    ")
        println("  $gameTime milliseconds         ")
        println("*-------------------------------*")
    }
}