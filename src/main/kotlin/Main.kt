import javafx.stage.Stage
import tornadofx.*

class MainMenu : App(MainMenuView::class) {
    init {importStylesheet("/styles.css")}
    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = true
    }
}
fun main(args: Array<String>) {launch<MainMenu>(args)}
