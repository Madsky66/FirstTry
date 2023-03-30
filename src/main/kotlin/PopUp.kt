import javafx.geometry.Pos
import tornadofx.*

class PopUp(private val message: String) : View("Popup") {
    override val root = stackpane {label(message) {alignment = Pos.CENTER}}
    init {
        with(root) {
            prefWidth = 300.0
            prefHeight = 200.0
        }
    }
    fun show() {openWindow()}
}
