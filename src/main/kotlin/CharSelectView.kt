import Managers.LanguageManager.languageManager
import tornadofx.*

class CharSelectView : View("Create character") {
    private val menuTitle = languageManager.getProperty("charselect_title") ?: "DEBUG"
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
            button("Emplacement 1") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    close()
                    crash("Non implementé")
                }
            }
            button("Emplacement 2") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    close()
                    crash("Non implementé")
                }
            }
            button("Emplacement 3") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    close()
                    crash("Non implementé")
                }
            }
            button("Emplacement 4") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    close()
                    crash("Non implementé")
                }
            }
            button("Emplacement 5") {
                style {
                    prefWidth = 200.px
                    fontSize = 20.px
                }
                action {
                    close()
                    crash("Non implementé")
                }
            }
        }
    }
}