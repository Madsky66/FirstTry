
import javafx.beans.property.SimpleObjectProperty
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

enum class Language(val fileName: String, val locale: Locale) {FRENCH("fr_FR.properties", Locale.FRENCH), ENGLISH("en_EN.properties", Locale.ENGLISH)}

object LanguageManager {
    val selectedLanguage = SimpleObjectProperty(Language.ENGLISH)
    private val languageProperties = Properties()

    init {loadSelectedLanguageProperties()}

    private fun loadSelectedLanguageProperties() {FileInputStream("src/main/resources/${selectedLanguage.get().fileName}").use {languageProperties.load(it)}}

    fun setLanguage(language: Language) {
        selectedLanguage.set(language)
        loadSelectedLanguageProperties()
    }

    fun save() {
        val file = File("src/main/resources/settings.properties")
        FileOutputStream(file).use { languageProperties.store(it, null) }
    }
}