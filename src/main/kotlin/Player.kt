class Player(private var posY: Int, private var posX: Int) {

    private val asset: Char = 'P'

    private fun validateMove(
        directionY: Int,
        directionX: Int,
        mapLayout: GameMap,
        arrayOfBoxes: Array<Box>,
        inputKey: Char
    ): Boolean {

        if (mapLayout.design[posY + directionY][posX + directionX] == '#') {
            return false
        } else if (mapLayout.design[posY + directionY][posX + directionX] == 'B') {

            val box = arrayOfBoxes.firstOrNull {
                it.posX == this.posX + directionX && it.posY == this.posY + directionY
            } // this will get you the box you are interacting with

            return box?.performMove(inputKey, mapLayout) ?: false
        } else if (mapLayout.design[posY + directionY][posX + directionX] == '*') {
            return true
        }
        return true
    }

    fun performMove(inputKey: Char, gameMap: GameMap, arrayOfBoxes: Array<Box>) {


        when (inputKey.lowercaseChar()) {

            'w' -> {
                if (validateMove(-1, 0, gameMap, arrayOfBoxes, inputKey)) {
                    gameMap.design[posY][posX] = ' '
                    posY -= 1
                    gameMap.design[posY][posX] = asset
                } else {
                    System.err.println("Can't go there I'm afraid")
                }
            }

            'a' -> {
                if (validateMove(0, -1, gameMap, arrayOfBoxes, inputKey)) {
                    gameMap.design[posY][posX] = ' '
                    posX -= 1
                    gameMap.design[posY][posX] = asset
                } else {
                    System.err.println("Can't go there I'm afraid")
                }
            }

            's' -> {
                if (validateMove(1, 0, gameMap, arrayOfBoxes, inputKey)) {
                    gameMap.design[posY][posX] = ' '
                    posY += 1
                    gameMap.design[posY][posX] = asset
                } else {
                    System.err.println("Can't go there I'm afraid")
                }
            }

            'd' -> {
                if (validateMove(0, 1, gameMap, arrayOfBoxes, inputKey)) {
                    gameMap.design[posY][posX] = ' '
                    posX += 1
                    gameMap.design[posY][posX] = asset
                } else {
                    System.err.println("Can't go there I'm afraid")
                }
            }

            'q' -> {
                gameMap.terminateProgram()
            }

            else -> System.err.println(errorMessage)
        }
    }
}