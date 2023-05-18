package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivitySubsektorBinding
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SubsektorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubsektorBinding
    private var mediaPlayer1: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubsektorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPlay1.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release() // Release any previously initialized media player
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf1)
                mediaPlayer1?.start()
            }
            btnPlay2.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf2)
                mediaPlayer1?.start()
            }
            btnPlay3.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf3)
                mediaPlayer1?.start()
            }

            btnPlay4.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf4)
                mediaPlayer1?.start()
            }
            btnPlay5.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf5)
                mediaPlayer1?.start()
            }
            btnPlay6.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf6)
                mediaPlayer1?.start()
            }
            btnPlay7.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf7)
                mediaPlayer1?.start()
            }
            btnPlay8.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf8)
                mediaPlayer1?.start()
            }
            btnPlay9.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf9)
                mediaPlayer1?.start()
            }
            btnPlay10.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf10)
                mediaPlayer1?.start()
            }
            btnPlay11.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf11)
                mediaPlayer1?.start()
            }
            btnPlay12.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf12)
                mediaPlayer1?.start()
            }
            btnPlay13.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf13)
                mediaPlayer1?.start()
            }
            btnPlay14.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf14)
                mediaPlayer1?.start()
            }
            btnPlay15.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf15)
                mediaPlayer1?.start()
            }
            btnPlay16.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf16)
                mediaPlayer1?.start()
            }
            btnPlay17.setOnClickListener {
                stopPlaying()
                mediaPlayer1?.release()
                mediaPlayer1 = MediaPlayer.create(applicationContext, R.raw.ekraf17)
                mediaPlayer1?.start()
            }
            btnNext.setOnClickListener {
                Intent(this@SubsektorActivity, SixteenActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
            btnPrev.setOnClickListener {
                Intent(this@SubsektorActivity, FifteenActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        stopPlaying()
    }

    private fun stopPlaying() {
        mediaPlayer1?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        mediaPlayer1 = null
    }
}
