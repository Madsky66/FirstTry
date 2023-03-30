
import tornadofx.*

class CharCreateView : View("Create character") {
    class CharacterModel : ViewModel() {
        val charFirstName = stringProperty()
        val charLastName = stringProperty()
        val charAge = intProperty()
        val charHeight = doubleProperty()
        val charWeight = doubleProperty()
        val charRace = stringProperty()
        val charClass = stringProperty()
        val charStory = stringProperty()
    }
    private val model = CharacterModel()
    override val root = form {
        prefWidth = 800.0
        prefHeight = 600.0
        fieldset("Général") {
            field("Race[s]") {textfield(model.charRace)}
            field("Classe[s]") {textfield(model.charClass)}
            field("Prénom[s]") {textfield(model.charFirstName)}
            field("Nom[s]") {textfield(model.charLastName)}
        }
        fieldset ("Caractéristiques") {
            field("Age") {spinner(0.0, 100.0, 18.0, 1.0, true, model.charAge)}
            field("Taille [cm]") {spinner(0.0, 300.0, 150.0, 1.0, true, model.charHeight)}
            field("Poids [kg]") {spinner(0.0, 200.0, 50.0, 0.5, true, model.charWeight)}
        }
        fieldset ("Histoire") {field {textarea(model.charStory)}}
        buttonbar {
            button("Aperçu") {action {close()}}
            button("Confirmer") {
                isDefaultButton = true
                action {close()}
            }
            button("Annuler") {
                isCancelButton = true
                action {
                    val gameView = find<NewGameView>()
                    replaceWith(gameView)
                }
            }
        }
    }
}