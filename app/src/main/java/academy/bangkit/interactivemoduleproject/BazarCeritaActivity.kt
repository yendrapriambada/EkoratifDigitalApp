package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityBazarCeritaBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BazarCeritaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBazarCeritaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBazarCeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@BazarCeritaActivity, HargaProdukActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@BazarCeritaActivity, PersiapanUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}