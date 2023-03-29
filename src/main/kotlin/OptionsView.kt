
import LanguageManager.selectedLanguage
import javafx.collections.FXCollections
import tornadofx.*

class OptionsView : View("Options") {

    private val audioManager = AudioManager()
    private val languageManager = LanguageManager
    val currentMainMenuView: MainMenuView by param()

    override val root = vbox {
        spacing = 10.0
        paddingAll = 20.0

        label("Options") {style {fontSize = 24.px}}

        hbox {
            label("Volume : ")
            slider {
                min = 0.0
                max = 100.0
                valueProperty().addListener {_, _, newValue -> audioManager.setMasterVolume(newValue.toDouble() / 100.0)}
            }
        }

        hbox {
            label("Langue : ")
            combobox<Language>(selectedLanguage) {
                items = FXCollections.observableArrayList(Language.ENGLISH, Language.FRENCH)
                cellFormat { text = it.toString() }
                valueProperty().addListener { _, _, newValue ->
                    LanguageManager.setLanguage(newValue)
                }
            }
        }


        button("Enregistrer") {
            style {
                prefWidth = 100.px
                fontSize = 16.px
            }
            action {
                // AJOUTER CODE POUR VALIDER LES CHANGEMENTS ICI
                close()
            }
        }
    }
}