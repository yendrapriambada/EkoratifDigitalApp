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

        val scoreNow = pref.getInt("score", 0)
        val nama = pref.getString("nama", "Siswa/Siswi")
        binding.tvScore.text = scoreNow.toString().trim()
        binding.tvNama.text = buildString {
        append("Halo, ")
        append(nama.toString().trim())
    }

        binding.btnUlangEvaluasi.setOnClickListener{
            val editor: SharedPreferences.Editor = pref.edit()
            editor.remove("score");
            editor.apply();

            val scoreAfterClear = pref.getInt("score", 0)
            if (scoreAfterClear == 0){
                val intent = Intent(this, NineTeenActivity::class.java)
                startActivity(intent)
            }
        }

        binding.btnMenu.setOnClickListener {
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }


    }
}