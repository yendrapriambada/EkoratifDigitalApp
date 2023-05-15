package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivitySevenBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnMenu.setOnClickListener {
                Intent(this@SevenActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}