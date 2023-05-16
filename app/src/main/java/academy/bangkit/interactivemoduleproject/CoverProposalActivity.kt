package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityCoverProposalBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CoverProposalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoverProposalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoverProposalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            btnPrev.setOnClickListener {
                Intent(this@CoverProposalActivity, ProyekWawancara2Activity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                Intent(this@CoverProposalActivity, IdeUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}