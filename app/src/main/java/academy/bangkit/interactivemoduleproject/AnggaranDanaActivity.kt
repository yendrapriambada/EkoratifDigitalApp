package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityAnggaranDanaBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AnggaranDanaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnggaranDanaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnggaranDanaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            btnPrev.setOnClickListener {
                Intent(this@AnggaranDanaActivity, RencanaUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@AnggaranDanaActivity, HargaProdukActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}