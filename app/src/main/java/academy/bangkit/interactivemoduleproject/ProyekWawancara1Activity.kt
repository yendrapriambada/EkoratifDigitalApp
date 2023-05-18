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

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataQWawancara = sharedPref.getString("qWawancara", "default").toString()
        if (dataQWawancara != "default")
            binding.edtPertanyaanwawancara.setText(dataQWawancara)

        binding.btnNext.setOnClickListener {
            editor.putString("qWawancara", binding.edtPertanyaanwawancara.text.toString().trim())
            editor.apply()

            Intent(this, ProyekWawancara2Activity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}