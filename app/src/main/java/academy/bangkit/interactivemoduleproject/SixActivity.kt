package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivitySixBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SixActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnMenu.setOnClickListener {
                Intent(this@SixActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}