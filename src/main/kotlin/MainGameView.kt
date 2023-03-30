import tornadofx.*

class MainGameView : View("My Game") {
    var game = Game()
    private val scoreLabel = label("Score: ${game.score}")
    private val livesLabel = label("Lives: ${game.lives}")

    override val root = vbox {
        scoreLabel
        livesLabel
        button("Move Left") {
            action {
                game.performPlayerAction(Game.PlayerAction.MOVE_LEFT)
                updateLabels()
            }
        }
        button("Move Right") {
            style {
                prefWidth = 200.px
                fontSize = 20.px
            }
            setOnAction { close() }
        }
    }

    private fun updateLabels() {
        scoreLabel.text = "Score: ${game.score}"
        livesLabel.text = "Lives: ${game.lives}"
    }
}