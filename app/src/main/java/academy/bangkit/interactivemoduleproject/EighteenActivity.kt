package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityEighteenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivitySevenTeenBinding
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EighteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEighteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEighteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.edtRefleksi321.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        val dataRefleksi321 = sharedPref.getString("refleksi321","default").toString()

        if (dataRefleksi321!= "default"){
            binding.edtRefleksi321.setText(dataRefleksi321)
        }

        binding.btnMenu.setOnClickListener {
            editor.putString("refleksi321", binding.edtRefleksi321.text.toString().trim())
            editor.apply()
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}