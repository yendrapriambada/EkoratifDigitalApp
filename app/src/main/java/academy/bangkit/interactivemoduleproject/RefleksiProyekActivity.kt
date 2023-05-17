package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityRefleksiProyekBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RefleksiProyekActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRefleksiProyekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefleksiProyekBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@RefleksiProyekActivity, SevenTeenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}