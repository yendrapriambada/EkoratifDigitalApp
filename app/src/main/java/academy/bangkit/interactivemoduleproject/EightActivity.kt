package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityEightBinding
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataEkonomi = sharedPref.getString("defEkonomi", "default").toString()
        if (dataEkonomi != "default")
            binding.editText.setText(dataEkonomi)

        binding.btnNext.setOnClickListener {

            editor.putString("defEkonomi", binding.editText.text.toString().trim())
            editor.apply()

            Intent(this, NineActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}