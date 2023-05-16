package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityProduksi2Binding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Produksi2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityProduksi2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProduksi2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, TwelveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        binding.btnPrev.setOnClickListener {
            Intent(this, ElevenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}