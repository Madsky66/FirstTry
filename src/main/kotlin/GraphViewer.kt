import org.graphstream.graph.Graph
import org.graphstream.graph.implementations.SingleGraph
import tornadofx.*

class GraphViewer : View("My View") {override val root = borderpane {}}

object GraphStreamer {
    fun main(args: Array<String>) {
        val graph: Graph = SingleGraph("Tutorial 1")
        System.setProperty("org.graphstream.ui", "swing")
        graph.display()
    }
}



