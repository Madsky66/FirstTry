import java.time.LocalDateTime

class NewGame {



    enum class GameState {NOT_STARTED, STARTED}
    enum class PlayerAction {JUMP, MOVE_LEFT, MOVE_RIGHT}

    fun startNewGame() {
        val startHealth = 100
        val startDate = LocalDateTime.now()
        Game(startHealth,  startDate)
    }
}