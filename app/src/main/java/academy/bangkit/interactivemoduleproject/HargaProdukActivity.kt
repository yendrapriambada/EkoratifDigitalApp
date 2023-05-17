package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityHargaProdukBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HargaProdukActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHargaProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHargaProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@HargaProdukActivity, AnggaranDanaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@HargaProdukActivity, BazarCeritaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}