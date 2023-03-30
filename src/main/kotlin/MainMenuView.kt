
import LanguageManager.languageManager
import tornadofx.*

class MainMenuView : View("Main Menu") {
    private val menuTitleText = languageManager.getProperty("menu_title_text") ?: "Que voulez-vous faire ?"
    private val newGameButtonText = languageManager.getProperty("new_game_text") ?: "Nouvelle partie"
    private val loadGameButtonText = languageManager.getProperty("load_game_text") ?: "Charger partie"
    private val optionsButtonText = languageManager.getProperty("options_text") ?: "Options"
    private val exitButtonText = languageManager.getProperty("exit_text") ?: "Quitter"

    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0

        center = vbox(20) {
            style {
                padding = box(50.px)
                alignment = javafx.geometry.Pos.CENTER
            }

            label(menuTitleText) {
                id = "menuTitle"
                style { fontSize = 40.px }
            }

            button(newGameButtonText) {
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

            button(loadGameButtonText) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {close()}
            }

            button(optionsButtonText) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {find<OptionsView>(OptionsView::currentMainMenuView to this@MainMenuView).openModal()}
            }

            button(exitButtonText) {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {close()}
            }
        }
    }
}