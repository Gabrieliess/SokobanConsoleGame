var gameFinished: Boolean = false
var moveCounter: Long = 0
var gameTime: Long = 0
var startingTime: Long = 0

const val errorMessage: String = "Invalid input! Use W,A,S,D for movement or Q to exit the program."

fun main() {
    val gameMap = GameMap()
    val player = Player(6, 3)

    val box1 = Box(2, 2)
    val box2 = Box(3, 5)
    val box3 = Box(4, 3)

    val arrayOfBoxes: Array<Box> = arrayOf(box1, box2, box3)

    val boxDropArea1 = BoxDropArea(6, 4)
    val boxDropArea2 = BoxDropArea(6, 5)
    val boxDropArea3 = BoxDropArea(6, 6)

    val arrayOfDropAres: Array<BoxDropArea> = arrayOf(boxDropArea1, boxDropArea2, boxDropArea3)

    gameMap.gameTimer(false)

    while (!gameFinished) {
        gameMap.printMap()

        val input = readln()

        if (input.isEmpty()) {
            System.err.println(errorMessage)
        } else {
            player.performMove(input[0], gameMap, arrayOfBoxes)
            moveCounter++

            for (element in arrayOfDropAres) {
                element.renderDropArea(gameMap)
            }
        }

        if (gameMap.isGameWon(gameMap)) {
            gameMap.gameTimer(true)
            gameMap.endTheGame(moveCounter)
            gameFinished = true
        }
    }

}