package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityRencanaUsahaBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RencanaUsahaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRencanaUsahaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRencanaUsahaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@RencanaUsahaActivity, CoverProposalActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@RencanaUsahaActivity, AnggaranDanaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}