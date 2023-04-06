import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Modality
import javafx.stage.Stage
import kotlin.reflect.KClass

/*lateinit var fXML: String
lateinit var windowsTitle: String
lateinit var className: KClass<*>*/

class ViewManager {
    fun openView(className: KClass<ChatController>, windowsTitle: String, fXML: String) {
        val loader = FXMLLoader()
        val url = className.java.getResource(fXML)
        loader.location = url
        loader.setRoot(Pane())
        val root: Parent = loader.load()
        val apiViewStage = Stage()
        apiViewStage.initModality(Modality.APPLICATION_MODAL)
        apiViewStage.title = windowsTitle
        apiViewStage.scene = Scene(root, 800.0, 600.0)
        apiViewStage.show()
    }
}