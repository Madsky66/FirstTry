import tornadofx.*

class MainGameView : View("My Game") {
    var game = Game()

    override val root = vbox {
        val healthText = "healthText"
        val moveRightText = "moveRightText"

        label("Score : ${game.score}")
        label("$healthText : ${game.lives}")

        button(moveRightText) {
            style {
                prefWidth = 200.px
                fontSize = 20.px
            }
            setOnAction { close() }
        }

        button {
            action {
                game.performPlayerAction(Game.PlayerAction.MOVE_RIGHT)
            }
        }

        fun updateView() {
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
}