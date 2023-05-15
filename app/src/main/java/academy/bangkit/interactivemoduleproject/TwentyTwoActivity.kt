package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityTwentyOneBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivityTwentyTwoBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TwentyTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, TwentyThreeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}