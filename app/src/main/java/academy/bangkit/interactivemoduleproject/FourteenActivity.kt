package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFourteenBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FourteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnMenu.setOnClickListener {
                Intent(this@FourteenActivity, FiveActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}