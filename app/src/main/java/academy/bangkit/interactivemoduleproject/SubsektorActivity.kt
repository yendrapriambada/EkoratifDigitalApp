package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivitySubsektorBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SubsektorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubsektorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubsektorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
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
            btnPlay1.setOnClickListener {

            }
            btnPlay2.setOnClickListener {

            }
        }
    }
}