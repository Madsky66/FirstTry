
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.FloatControl
import kotlin.math.log10

class AudioManager {
    fun setMasterVolume(volume: Double) {
        val mixer = AudioSystem.getMixer(null)
        val controls = mixer.controls
        for (control in controls) {
            if (control is FloatControl) {
                if (control.type == FloatControl.Type.MASTER_GAIN) {
                    control.value = (20f * log10(volume)).toFloat()
                    break
                }
            }
        }
    }
}