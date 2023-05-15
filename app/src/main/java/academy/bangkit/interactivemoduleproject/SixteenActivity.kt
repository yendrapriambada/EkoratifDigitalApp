package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFourteenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivitySixteenBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SixteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnMenu.setOnClickListener {
                Intent(this@SixteenActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}