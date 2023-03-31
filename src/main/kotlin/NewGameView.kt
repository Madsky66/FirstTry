import LanguageManager.languageManager
import tornadofx.*

class NewGameView : View("New Game") {
    private val menuTitle = languageManager.getProperty("newgame_title") ?: "DEBUG"
    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0
        center = vbox(20) {
            style {
                padding = box(50.px)
                alignment = javafx.geometry.Pos.CENTER
            }
            label(menuTitle) {
                id = "menuTitle"
                style { fontSize = 40.px }
            }
            button("Mise à jour des textes") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {updateLabels()}
            }
            button("Créer personnage") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    val gameView = find<CharCreateView>()
                    replaceWith(gameView)
                }
            }
            button("Choisir personnage") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    val gameView = find<CharSelectView>()
                    replaceWith(gameView)
                }
            }
            button("Retour") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    val gameView = find<MainMenuView>()
                    replaceWith(gameView)
                }
            }
        }
    }

    private fun updateLabels() {
        //healthLabel.text = "Health : ${game.actualHealth}"
        //dateLabel.text = "Date : ${game.lives}"
    }
}