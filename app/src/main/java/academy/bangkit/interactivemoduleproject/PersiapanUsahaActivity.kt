package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityPersiapanUsahaBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PersiapanUsahaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersiapanUsahaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersiapanUsahaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@PersiapanUsahaActivity, BazarCeritaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnMenu.setOnClickListener {
                Intent(this@PersiapanUsahaActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}