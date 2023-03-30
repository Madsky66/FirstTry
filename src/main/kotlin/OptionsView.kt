
import SettingsManager.settingsManager
import javafx.beans.property.SimpleStringProperty
import tornadofx.*


class OptionsView : View("Options") {

    private val selectedLanguageProperty = SimpleStringProperty()
    private var selectedLanguage: String by selectedLanguageProperty
    private var selectedVolume by property<Int>()
    private val audioManager = AudioManager()

    val currentMainMenuView: MainMenuView by param()

    override val root = vbox {
        spacing = 10.0
        paddingAll = 20.0

        label("Options") {style {fontSize = 24.px}}

        hbox {
            label("Volume : ")
            slider(0, 100, selectedVolume) {
                valueProperty().addListener { _, _, newVolume ->
                    audioManager.setMasterVolume(newVolume.toDouble() / 100.0)
                    selectedVolume = newVolume?.toInt()
                }
            }
        }

        hbox {
            selectedLanguage = settingsManager.getProperty("language", "french") ?: "french"
            label("Langue : ")
            combobox(values = listOf("english", "french")) {valueProperty().bindBidirectional(selectedLanguageProperty)}
        }

        button("Enregistrer") {
            style {
                prefWidth = 100.px
                fontSize = 16.px
            }
            action {
                SettingsManager.modify(selectedVolume, selectedLanguageProperty.value, true)
                close()
            }
        }
    }
    init {selectedVolume = settingsManager.getProperty("volume", "50")?.toInt() ?: 50}
}