package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityElevenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivityTwelveBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TwelveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwelveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwelveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrev.setOnClickListener{
            Intent(this@TwelveActivity, TenActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}