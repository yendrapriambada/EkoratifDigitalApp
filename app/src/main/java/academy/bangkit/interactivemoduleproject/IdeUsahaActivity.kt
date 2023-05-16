package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityIdeUsahaBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IdeUsahaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdeUsahaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeUsahaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            btnPrev.setOnClickListener {
                Intent(this@IdeUsahaActivity, CoverProposalActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@IdeUsahaActivity, RencanaUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}