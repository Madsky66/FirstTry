
import tornadofx.*
import java.util.*

class OptionsView : View("Options") {
    private val audioManager = AudioManager()
    private val langManager = LanguageManager

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
            val languages = listOf("Français", "Anglais")
            combobox<String> {
                items = observableListOf(languages)
                valueProperty().addListener { _, _, newValue ->
                    when(newValue) {
                        "Français" -> {langManager.setLanguage(Locale("fr", "FR"))}
                        "Anglais" -> {langManager.setLanguage(Locale("en", "EN"))}
                    }
                }
            }
        }

        button("Enregistrer") {
            style {
                prefWidth = 100.px
                fontSize = 16.px
            }
            action {close()}
        }
    }
}