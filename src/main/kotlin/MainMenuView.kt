import tornadofx.*

class MainMenuView : View("FirstTry") {
    override val root = borderpane {
        val langManager = LanguageManager
        prefWidth = 800.0
        prefHeight = 600.0
        center = vbox(20) {
            style {
                padding = box(50.px)
                alignment = javafx.geometry.Pos.CENTER
            }

            val playText = langManager.getString("menu_title_text")

            label(playText) {style {fontSize = 40.px}}

            button("Nouvelle partie") {
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

            button("Charger partie") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                setOnAction {close()}
            }

            button("Options") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {openInternalWindow<OptionsView>(modal = true)}
            }

            button("Quitter") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {close()}
            }
        }
    }
}