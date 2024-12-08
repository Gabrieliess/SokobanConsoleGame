class Box(var posY: Int, var posX: Int) {

    private val asset: Char = 'B'

    private fun validateMovement(directionY: Int, directionX: Int, mapLayout: GameMap): Boolean {
        return if (mapLayout.design[posY + directionY][posX + directionX] == '#') {
            println("There is wall in front on the box")
            false
        } else if (mapLayout.design[posY + directionY][posX + directionX] == 'B') {
            println("You are pushing 2 boxes")
            false
        } else {
            true
        }
    }


    fun performMove(inputKey: Char, gameMap: GameMap):Boolean {

        when (inputKey.lowercaseChar()) {

            'w' -> {
                return if (validateMovement(-1, 0, gameMap)) {
                    gameMap.design[posY][posX] = ' '
                    posY -= 1
                    gameMap.design[posY][posX] = asset
                    true
                } else {
                    false
                }
            }

            'a' -> {
                return if (validateMovement(0, -1, gameMap)) {
                    gameMap.design[posY][posX] = ' '
                    posX -= 1
                    gameMap.design[posY][posX] = asset
                    true
                } else {
                    false
                }
            }

            's' -> {
                return if (validateMovement(1, 0, gameMap)) {
                    gameMap.design[posY][posX] = ' '
                    posY += 1
                    gameMap.design[posY][posX] = asset
                    true
                } else {
                    false
                }
            }

            'd' -> {
                return if (validateMovement(0, 1, gameMap)) {
                    gameMap.design[posY][posX] = ' '
                    posX += 1
                    gameMap.design[posY][posX] = asset
                    true
                } else {
                    false
                }
            }
        }
        return false
    }
}