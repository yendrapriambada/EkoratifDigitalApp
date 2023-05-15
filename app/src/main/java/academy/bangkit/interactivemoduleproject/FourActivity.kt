package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFourBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivityThreeBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FourActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnPrev.setOnClickListener {
            Intent(this, ThreeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}