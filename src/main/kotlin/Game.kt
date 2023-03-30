import java.time.LocalDateTime

class Game(actualHealth: Int, actualDate: LocalDateTime) {

    var health = actualHealth
    var date = actualDate

    private var gameOver: Boolean = false
    private var gameState: GameState = GameState.NOT_STARTED

    enum class GameState {NOT_STARTED, STARTED}
    enum class PlayerAction {EAT, JUMP, MOVE_LEFT, MOVE_RIGHT}

    fun startGame() {gameState = GameState.STARTED}

    fun performPlayerAction(action: PlayerAction) {
        if (!gameOver && gameState == GameState.STARTED) {
            when (action) {
                PlayerAction.EAT -> eat()
                PlayerAction.JUMP -> jump()
                PlayerAction.MOVE_LEFT -> moveLeft()
                PlayerAction.MOVE_RIGHT -> moveRight()
            }
        }
    }

    private fun eat() {TODO("Todo")}
    private fun jump() {TODO("Todo")}
    private fun moveLeft() {TODO("Todo")}
    private fun moveRight() {TODO("Todo")}
}