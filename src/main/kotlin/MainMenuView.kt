import tornadofx.*


class MainMenuView : View("FirstTry") {
    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0
        center = vbox(20) {
            style {
                padding = box(50.px)
                alignment = javafx.geometry.Pos.CENTER
            }

            label("Que voulez-vous faire ?") {
                style {
                    fontSize = 40.px
                }
            }

            button("Nouvelle partie") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }

                setOnAction {
                    // Code pour démarrer une nouvelle partie
                }
            }

            button("Charger partie") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }

                setOnAction {
                    // Code pour démarrer une nouvelle partie
                }
            }

            button("Options") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }

                action {
                    openInternalWindow<OptionsView>(modal = true)
                }
            }

            button("Quitter") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }

                setOnAction {
                    // Code pour quitter le jeu
                }
            }
        }
    }
}

class MasterView: View() {
    override val root = borderpane {
        top<TopView>()
        bottom<BottomView>()
    }
}

class TopView: View() {
    override val root = label("Top View")
}

class BottomView: View() {
    override val root = label("Bottom View")
}