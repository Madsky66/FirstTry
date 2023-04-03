import javafx.geometry.Pos
import tornadofx.*

class CharConfirmView : View("Character Confirmation") {
    private val charModel: CharacterModel by inject()
    override val root = borderpane {
        center = form {
            fieldset("Character Information") {
                field("First Name") {label(charModel.charFirstName)}
                field("Last Name") {label(charModel.charLastName)}
                field("Age") {label(charModel.charDate)}
                field("Height") {label(charModel.charHeight)}
                field("Weight") {label(charModel.charWeight)}
                field("Sex") {label(charModel.charSex)}
                field("Gender") {label(charModel.charGender)}
                field("Race") {label(charModel.charRace)}
                field("Class") {label(charModel.charClass)}
                field("Story") {label(charModel.charStory)}
            }
            hbox(spacing = 20, alignment = Pos.CENTER) {
                button("Edit") {action {replaceWith<CharCreateView>()}}
                button("Save") {
                    action {
                        close()
                        pop(CRASH)
                    }
                }
            }
        }
    }
}