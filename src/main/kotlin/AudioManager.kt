import javax.sound.sampled.AudioSystem
import javax.sound.sampled.FloatControl
import kotlin.math.log10
import kotlin.math.pow

class AudioManager {
    fun setMasterVolume(volume: Double) {
        val mixer = AudioSystem.getMixer(null)
        val controls = mixer.controls
        for (control in controls) {
            if (control is FloatControl) {
                val floatControl = control as FloatControl
                if (floatControl.type == FloatControl.Type.MASTER_GAIN) {
                    floatControl.value = (20f * log10(volume)).toFloat()
                    break
                }
            }
        }
    }

    fun getMasterVolume(): Float {
        val mixer = AudioSystem.getMixer(null)
        val controls = mixer.controls
        for (control in controls) {
            if (control is FloatControl) {
                val floatControl = control as FloatControl
                if (floatControl.type == FloatControl.Type.MASTER_GAIN) {
                    return (10.0.pow(floatControl.value.toDouble() / 20.0)).toFloat()
                }
            }
        }
        return 0f
    }
}