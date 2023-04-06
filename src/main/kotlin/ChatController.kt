
import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.text.TextFlow
import javafx.stage.Stage

var chatAnswer = ""
var input = ""

class ChatController : Application() {
    companion object {@JvmStatic fun main(args: Array<String>) {launch(ChatController::class.java, *args)}}
    lateinit var chatAnswerArea: TextFlow
    lateinit var chatInputField: TextArea
    lateinit var chatInputButton: Button
    override fun start(stage: Stage) {
        val loader = FXMLLoader()
        val url = javaClass.getResource("/ChatView.fxml")
        loader.location = url
        val root: Parent = loader.load()
        stage.scene = Scene(root)
        stage.isFullScreen = true
        stage.isMaximized = true
        stage.isResizable = false
        stage.show()
        chatInputButton.setOnAction {onChatInputButtonClick()}
    }
    @FXML fun onChatInputButtonClick() {
        input = chatInputField.text
        chatInputField.text = ""
        chat(this@ChatController)
    }
}