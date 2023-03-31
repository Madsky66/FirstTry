
import javafx.geometry.Pos
import javafx.scene.control.TabPane
import javafx.scene.layout.Priority
import tornadofx.*
import java.time.LocalDate

class CharCreateView : View("Create character") {
    private val charModel: CharacterModel by inject()
    override val root = borderpane {
        center {
            vbox(spacing = 10) {
                tabpane {
                    tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
                    tab("Configuration générale") {
                        form {
                            prefWidth = 800.0
                            prefHeight = 600.0
                            vbox(spacing = 10, alignment = Pos.CENTER) {
                                vgrow = Priority.ALWAYS
                                hgrow = Priority.ALWAYS
                                fieldset("Général :") {
                                    field("Race[s]") { textfield(charModel.charRace) }
                                    field("Classe[s]") { textfield(charModel.charClass) }
                                    field("Prénom[s]") { textfield(charModel.charFirstName) }
                                    field("Nom[s]") { textfield(charModel.charLastName) }
                                }
                                hbox(spacing = 50, alignment = Pos.CENTER) {
                                    hgrow = Priority.ALWAYS
                                    fieldset("Caractéristiques :") {
                                        alignment = Pos.TOP_LEFT
                                        field("Age") { datepicker() {value = LocalDate.of(charModel.charBirthYear.value, charModel.charBirthMonth.value, charModel.charBirthDay.value)}}
                                        field("Taille [cm]") { spinner(0.0, 300.0, 150.0, 1.0, true, charModel.charHeight) }
                                        field("Poids [kg]") { spinner(0.0, 200.0, 50.0, 0.5, true, charModel.charWeight) }
                                        field("Sexe[s]") { textfield(charModel.charSex) }
                                        field("Genre[s]") { textfield(charModel.charGender) }
                                    }
                                    fieldset("Statistiques 1/3 :") {
                                        alignment = Pos.TOP_RIGHT
                                        field("Force") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charStrength) }
                                        field("Dextérité") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charDexterity) }
                                        field("Rapidité") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charSpeed) }
                                        field("Endurance") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charEndurance) }
                                        field("Agilité") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charAgility) }
                                    }
                                    fieldset("Statistiques 2/3 :") {
                                        alignment = Pos.TOP_RIGHT
                                        field("Précision") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charAccuracy) }
                                        field("Perception") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charPerception) }
                                        field("Furtivité") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charStealth) }
                                        field("Résistance") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charResistance) }
                                        field("Volonté") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charWillpower) }
                                    }
                                    fieldset("Statistiques 3/3 :") {
                                        alignment = Pos.TOP_RIGHT
                                        field("Éloquence") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charEloquence) }
                                        field("Chance") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charLuck) }
                                        field("Charisme") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charCharisma) }
                                        field("Persuasion") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charPersuasion) }
                                        field("Savoir") { spinner(0.0, 100.0, 10.0, 1.0, true, charModel.charKnowledge) }
                                    }
                                }
                                fieldset("Histoire") { field { textarea(charModel.charStory) { prefHeight = 50.0 } } }
                            }
                        }
                    }
                    tab("Configuration 2/2") {}
                }
                buttonbar {
                    button("Aperçu") {
                        isDefaultButton = true
                        action {
                            val gameView = find<CharConfirmView>()
                            replaceWith(gameView)
                        }
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
    }
}