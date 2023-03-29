import javafx.stage.Stage
import tornadofx.*

class Main : App(MainMenuView::class) {
    init {
        var currentLanguage: String = Language.FRENCH.toString()
        importStylesheet("/styles.css")
    }
    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = true
    }
}
fun main(args: Array<String>) {launch<Main>(args)}