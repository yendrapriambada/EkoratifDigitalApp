package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityProyekWawancara2Binding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProyekWawancara2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityProyekWawancara2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProyekWawancara2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            btnPrev.setOnClickListener {
                Intent(this@ProyekWawancara2Activity, ProyekWawancara1Activity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }

            btnNext.setOnClickListener {
                Intent(this@ProyekWawancara2Activity, CoverProposalActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}