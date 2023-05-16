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
        binding.btnNext.setOnClickListener{
            Intent(this@TwelveActivity, Distribusi2Activity::class.java).also {
                startActivity(it)
            }
        }
    }
}