import tornadofx.*

class MainGameView : View("My Game") {
    var game = Game()

    override val root = vbox {
        val langManager = LanguageManager
        val healthText = langManager.getString("health_text")
        val moveRightText = langManager.getString("move_right")

        label("Score : ${game.score}")
        label("$healthText : ${game.lives}")
        button(moveRightText) {
            action {
                game.performPlayerAction(Game.PlayerAction.MOVE_RIGHT)
                updateView()
            }
        }
    }

    private fun updateView() {
        root.children.clear()
        root.add(label("Score: ${game.score}"))
        root.add(label("Lives: ${game.lives}"))
        root.add(button("Move Left") {
            action {
                game.performPlayerAction(Game.PlayerAction.MOVE_LEFT)
                updateView()
            }
        })
        //replaceWith(VictoryView::class)
    }
}
