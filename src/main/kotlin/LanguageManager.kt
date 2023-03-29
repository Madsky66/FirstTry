import java.util.*

object LanguageManager {
    private var currentLocale: Locale = Locale.getDefault()
    fun setLanguage(locale: Locale) {currentLocale = locale}
    fun getString(key: String): String {
        val bundle = ResourceBundle.getBundle("Bundle", currentLocale)
        return bundle.getString(key)}
}
