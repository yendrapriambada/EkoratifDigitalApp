package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityNineBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, TenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        binding.btnPrev.setOnClickListener {
            Intent(this, EightActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}