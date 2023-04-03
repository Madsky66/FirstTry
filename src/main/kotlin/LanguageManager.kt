import SettingsManager.settingsManager
import java.io.FileInputStream
import java.util.*

object LanguageManager {
    private lateinit var languageInputStream: String
    val languageManager = Properties()
    fun check() {
        SettingsManager.load()
        val currentLanguage = settingsManager.getProperty("language", "fr_FR").toString()
        if (currentLanguage == "french") {languageInputStream = "src/main/resources/fr_FR.properties"}
        if (currentLanguage == "english") {languageInputStream = "src/main/resources/en_EN.properties"}}
    fun load() {
        check()
        FileInputStream(languageInputStream).use { languageManager.load(it)}
    }
}