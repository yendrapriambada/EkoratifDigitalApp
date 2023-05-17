package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityDistribusi2Binding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Distribusi2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDistribusi2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistribusi2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPrev.setOnClickListener {
            Intent(this, TwelveActivity::class.java).also {
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