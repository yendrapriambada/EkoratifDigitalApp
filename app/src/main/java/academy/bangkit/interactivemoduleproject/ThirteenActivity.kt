package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityElevenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivityThirteenBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ThirteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirteenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrev.setOnClickListener{
            Intent(this@ThirteenActivity, TenActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}