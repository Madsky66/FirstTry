
import tornadofx.*

class MainMenuView : View("Main Menu") {
    private val menuTitleText = "main_menu_title"
    private val newGameButtonText = "new_game"
    private val optionsButtonText = "options"
    private val exitButtonText = "exit"

    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        center = vbox(20) {
            style {
                padding = box(50.px)
                alignment = javafx.geometry.Pos.CENTER
            }

            label(menuTitleText.toString()) {
                id = "menuTitle"
                style { fontSize = 40.px }
            }

            button(newGameButtonText.toString()) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                setOnAction {
                    val game = Game()
                    val gameView = find<MainGameView>()
                    gameView.game = game
                    replaceWith(gameView)
                }
            }

            button(optionsButtonText.toString()) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    find<OptionsView>(
                        mapOf(
                            OptionsView::currentMainMenuView to this@MainMenuView
                        )
                    ).openModal()
                }
            }

            button(exitButtonText.toString()) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                setOnAction { close() }
            }
        }
    }
}