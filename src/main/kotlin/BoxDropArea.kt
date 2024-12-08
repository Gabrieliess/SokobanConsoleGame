class BoxDropArea(private val posY: Int, private val posX: Int) {

    private var isOccupied:Boolean = false

    fun renderDropArea(gameMap: GameMap){
        if(gameMap.design[posY][posX] == ' ') {
            isOccupied = false
            gameMap.design[posY][posX] = '*'
        }
        else if(gameMap.design[posY][posX] == 'B')
            isOccupied = true
    }
}