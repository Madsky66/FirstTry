import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

object SettingsManager {
    val settingsManager = Properties()
    private const val settingsInputStream = "src/main/resources/settings.properties"
    fun load() {FileInputStream(settingsInputStream).use {settingsManager.load(it)}}
    private fun save() {FileOutputStream(settingsInputStream).use {settingsManager.store(it, null)}}
    fun modify(newVolume: Int, newLanguage: String, isFullScreen: Boolean) {
        settingsManager.setProperty("volume", newVolume.toString())
        settingsManager.setProperty("language", newLanguage)
        settingsManager.setProperty("fullscreen", isFullScreen.toString())
        save()
    }
}