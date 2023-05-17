package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityKonsumsi2Binding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Konsumsi2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityKonsumsi2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonsumsi2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrev.setOnClickListener {
            Intent(this, ThirteenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        binding.btnNext.setOnClickListener {
            Intent(this, TenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}