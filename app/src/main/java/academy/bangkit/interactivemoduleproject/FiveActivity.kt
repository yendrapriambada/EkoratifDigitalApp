package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFiveBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@FiveActivity, FourActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgCp.setOnClickListener {
                Intent(this@FiveActivity, SixActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgTp.setOnClickListener {
                Intent(this@FiveActivity, SevenActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgMke.setOnClickListener {
                Intent(this@FiveActivity, EightActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgMek.setOnClickListener {
                Intent(this@FiveActivity, FifteenActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgLr.setOnClickListener {
                Intent(this@FiveActivity, SevenTeenActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgEval.setOnClickListener {
                Intent(this@FiveActivity, NineTeenActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgKunjaw.setOnClickListener {
                Intent(this@FiveActivity, TwentyOneActivity::class.java).also {
                    startActivity(it)
                }
            }
            imgDapus.setOnClickListener {
                Intent(this@FiveActivity, TwentyTwoActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}