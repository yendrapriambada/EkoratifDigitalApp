package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityElevenBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ElevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElevenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrev.setOnClickListener{
            Intent(this@ElevenActivity, TenActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}