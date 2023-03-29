class Game {
    var score: Int = 0
    var lives: Int = 3
    var gameOver: Boolean = false
    var gameState: GameState = GameState.NOT_STARTED

    enum class GameState {NOT_STARTED, STARTED}
    enum class PlayerAction {JUMP, MOVE_LEFT, MOVE_RIGHT}

    fun startNewGame() {
        gameState = GameState.STARTED
        score = 0
        lives = 3
    }

    fun performPlayerAction(action: PlayerAction) {
        if (!gameOver && gameState == GameState.STARTED) {
            when (action) {
                PlayerAction.MOVE_LEFT -> moveLeft()
                PlayerAction.MOVE_RIGHT -> moveRight()
                else -> {}
            }
            increaseScore(100)
        }
    }
    private fun moveLeft() {TODO("Todo")}
    private fun moveRight() {TODO("Todo")}
    fun decreaseLives() {
        if (!gameOver) {
            lives--
            if (lives <= 0) {gameOver = true}
        }
    }
    fun increaseScore(points: Int) {
        if (!gameOver) {
            score += points
        }
    }
}