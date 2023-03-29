import tornadofx.*

class OptionsView : View("Options") {
    override val root = vbox {
        spacing = 10.0
        paddingAll = 20.0

        label("Options") {
            style {
                fontSize = 24.px
            }
        }

        hbox {
            label("Volume : ")
            slider {
                min = 0.0
                max = 100.0
                valueProperty().addListener { _, _, newValue ->
                    // Code pour ajuster le volume du jeu en fonction de la valeur du slider
                }
            }
        }

        hbox {
            label("Langue : ")
            val languages = listOf("Français", "Anglais", "Espagnol")
            combobox<String> {
                items = observableListOf(languages)
                selectionModel.selectFirst()
                valueProperty().addListener { _, _, newValue ->
                    // Code pour changer la langue du jeu en fonction de la sélection de l'utilisateur
                }
            }
        }

        hbox {
            label("Difficulté : ")
            togglebutton("Facile") {
                isSelected = true
                action {
                    // Code pour changer la difficulté du jeu en fonction de la sélection de l'utilisateur
                }
            }
            togglebutton("Moyen") {
                action {
                    // Code pour changer la difficulté du jeu en fonction de la sélection de l'utilisateur
                }
            }
            togglebutton("Difficile") {
                action {
                    // Code pour changer la difficulté du jeu en fonction de la sélection de l'utilisateur
                }
            }
        }

        button("Enregistrer") {
            style {
                prefWidth = 100.px
                fontSize = 16.px
            }
            action {
                // Code pour enregistrer les options et fermer la fenêtre
                close()
            }
        }
    }
}
