import javafx.geometry.Pos
import tornadofx.*

var item: String = ""
class JSONManipulatorView : View("My View") {
    /*private val addedBranches: ObservableList<Pair<String, String>> = FXCollections.observableArrayList()
    private var taxonomyFile = File("src/main/kotlin/classification.json")
    private val json = Json { ignoreUnknownKeys = true }
    private var taxonomy = loadTaxonomy()*/
    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 600.0
        center = form {
            hbox {
                fieldset() {
                    val requete = textfield()
                    button("Tester la Database") {action {taxonSearch(requete.text).toString()}}
                }
                vbox {
                    fieldset("Ajouter une branche") {
                        val parentField = textfield("ID Parent")
                        val branchField = textfield("ID Enfant[s]")
                        button("Ajouter") {
                            action {
                                /*val parentId = parentField.text
                                val childId = branchField.text
                                val parentNode = taxonomy.findNodeById(parentId)
                                parentNode?.addChild(Taxon(childId))
                                addedBranches.add(Pair(parentId, childId))
                                savePreview()*/
                            }
                        }

                    }
                    fieldset("Remove Branch") {
                        val removeField = textfield("Branch ID")
                        button("Remove Branch") {
                            action {
                                /*val branchId = removeField.text
                                taxonomy.removeNodeById(branchId)*/
                            }
                        }
                    }
                    hbox {
                        alignment = Pos.CENTER
                        button("Afficher la taxonomie") {action {/*showTaxonomyPopup()*/}}
                        button("Enregistrer") {
                            action {
                                //saveTaxonomy()
                                close()
                            }
                        }
                        /*listview(addedBranches) {
                            cellFormat {
                                graphic = HBox().apply {
                                    children.addAll(
                                        Label(it.first).apply { textFill = Color.GRAY },
                                        Label(" > "),
                                        Label(it.second).apply { textFill = Color.GREEN }
                                    )
                                }
                            }
                        }*/
                    }
                }
            }
        }
    }
    /*private fun loadTaxonomy() = json.decodeFromString<Taxonomy>(taxonomyFile.readText())
    private fun savePreview() {
        taxonomyFile = File("src/main/kotlin/classification_preview.json")
        saveTaxonomy()
    }
    private fun confirmChanges() {
        taxonomyFile = File("src/main/kotlin/classification.json")
        saveTaxonomy()
    }
    private fun saveTaxonomy() = taxonomyFile.writeText(json.encodeToString(taxonomy))
    private fun showTaxonomyPopup() {
        val taxonomyText = json.encodeToString(taxonomy)
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Taxonomie actuelle"
        alert.headerText = null
        alert.contentText = taxonomyText
        alert.showAndWait()
    }*/
}