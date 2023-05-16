package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityNineTeenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivityProyekWawancara1Binding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProyekWawancara1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityProyekWawancara1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProyekWawancara1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, ProyekWawancara2Activity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}