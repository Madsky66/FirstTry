
import java.time.LocalDate
import kotlin.random.Random

class Maths {
    fun getRandom(min: Double, max: Double): Double {
        require(min < max) { "Invalid range [$min, $max]" }
        return min + Random.nextDouble() * (max - min)
    }
    fun randomDate(age: Int): String {
        val date: String
        val yearOfBirth = LocalDate.now().year - age
        val monthOfBirth = Random.nextInt(1, 13)
        val dayOfBirth = Random.nextInt(1, LocalDate.of(yearOfBirth, monthOfBirth, 1).lengthOfMonth() + 1)
        val dayString = if (dayOfBirth < 10) "0$dayOfBirth" else dayOfBirth.toString()
        val monthString = if (monthOfBirth < 10) "0$monthOfBirth" else monthOfBirth.toString()

        date = "$dayString/$monthString/$yearOfBirth"
        return date
    }
}