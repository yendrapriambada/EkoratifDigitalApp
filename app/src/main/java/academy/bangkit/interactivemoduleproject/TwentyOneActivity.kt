package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityTwentyOneBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TwentyOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu.setOnClickListener {
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}