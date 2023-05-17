package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityTwentyBinding
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TwentyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)

        val key = intent.getStringExtra("from")

        if (key == "scoreEvaluasi") {
            showLayoutScoreEvaluasi()
            val scoreNow = pref.getInt(key, 0)
            binding.apply {
                val skorPG = pref.getInt("scorePG", 0)
                val skorEssay = pref.getInt("scoreEssay", 0)

                tvSkorPg.text = skorPG.toString()
                tvSkorEssay.text = skorEssay.toString()

                tvScore2.text = scoreNow.toString().trim()
            }
        } else {
            val scoreNow = pref.getInt(key, 0)
            binding.tvScore.text = scoreNow.toString().trim()
        }


        val nama = pref.getString("nama", "Siswa/Siswi")
        binding.tvNama.text = buildString {
            append("Halo, ")
            append(nama.toString().trim())
        }

        binding.btnUlangEvaluasi.setOnClickListener {
            val editor: SharedPreferences.Editor = pref.edit()
            editor.remove(key);
            editor.apply();

            val scoreAfterClear = pref.getInt(key, 0)
            if (scoreAfterClear == 0) {
                if (key == "scoreEvaluasi") {
                    val intent = Intent(this, EvaluasiActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, NineTeenActivity::class.java)
                    startActivity(intent)
                }

            }
        }

        binding.btnMenu.setOnClickListener {
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun showLayoutScoreEvaluasi() {
        binding.apply {
            descEval.alpha = 1F
            tvPg.alpha = 1F
            tvEssay.alpha = 1F
            tvSkorPg.alpha = 1F
            tvSkorEssay.alpha = 1F
            tvTotal.alpha = 1F
            tvScore2.alpha = 1F


            descLatihan.alpha = 0F
            tvScore.alpha = 0F
        }
    }
}