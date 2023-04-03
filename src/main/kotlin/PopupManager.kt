
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*
import kotlin.system.exitProcess

const val CUSTOM = "CUSTOM"
const val CRASH = "CRASH"
const val TODO = "TODO"

var customMessage = "null"
var crashMessage = "Crash"
const val toDoMessage = "Cette fonctionnalité n'est pas encore implémentée"

class PopupManager: Fragment() {
    private val type: String by param()
    init {title = type}
    private val message = when (type) {
        CUSTOM -> customMessage
        CRASH -> crashMessage
        TODO -> toDoMessage
        else -> "DEBUG"
    }
    override val root = stackpane {
        prefWidth = 600.0
        prefHeight = 400.0
        label(message) {style {fontSize = 20.px}}
        when (type) {
            CUSTOM, TODO -> vbox(spacing = 10, alignment = Pos.CENTER) {
                        vgrow = Priority.ALWAYS
                        hgrow = Priority.ALWAYS
                        button("Retour") {action {close()}}
                        button("Quitter") {action {exitProcess(0)}}
                    }
            CRASH -> form {
                    vbox(spacing = 10, alignment = Pos.CENTER) {
                        vgrow = Priority.ALWAYS
                        hgrow = Priority.ALWAYS
                        fieldset("Général :") {field("Commentaire[s]") {textfield()}}
                        button("Envoyer") {action {close()}}
                        button("Quitter") {action {exitProcess(0)}}
                    }
            }
        }
    }
}

fun pop(type: String) {
    val popup = find<PopupManager>(params = mapOf("type" to type))
    popup.openModal(block = true)
}