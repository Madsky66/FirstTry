
import tornadofx.*

class CharacterModel : ViewModel() {

    private val randomAge = Maths().getRandom(18.0, 99.0).toInt()
    private val randomDateString = Maths().randomDate(randomAge)
    private val randomHeight = Maths().getRandom(100.0, 200.0)
    private val randomWeight = Maths().getRandom(30.0, 300.0)
    // TODO when (Maths().getRandom(1.0,2.9).toInt() == 1) {private val randomSex = randomSex = "Masculin"}

    val charFirstName = stringProperty("DEBUG")
    val charLastName = stringProperty("DEBUG")
    val charSex = stringProperty("sex") // TODO
    val charGender = stringProperty("DEBUG")
    val charRace = stringProperty("DEBUG")
    val charClass = stringProperty("DEBUG")
    val charStory = stringProperty("")

    val charDate = stringProperty(randomDateString)
    val charBirthDay = intProperty(randomDateString.substring(0, 2).toInt())
    val charBirthMonth = intProperty(randomDateString.substring(3, 5).toInt())
    val charBirthYear = intProperty(randomDateString.substring(6, 10).toInt())

    val charHeight = intProperty(randomHeight.toInt())
    val charWeight = doubleProperty(randomWeight)

    val charStrength = intProperty(0)
    val charDexterity = intProperty(0)
    val charAgility = intProperty(0)
    val charSpeed = intProperty(0)
    val charEndurance = intProperty(0)
    val charAccuracy = intProperty(0)
    val charPerception = intProperty(0)
    val charStealth = intProperty(0)
    val charResistance = intProperty(0)
    val charWillpower = intProperty(0)
    val charEloquence = intProperty(0)
    val charLuck = intProperty(0)
    val charCharisma = intProperty(0)
    val charPersuasion = intProperty(0)
    val charKnowledge = intProperty(0)
}
