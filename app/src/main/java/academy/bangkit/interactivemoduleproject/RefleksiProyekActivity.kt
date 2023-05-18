package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityRefleksiProyekBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RefleksiProyekActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRefleksiProyekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefleksiProyekBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val nama = sharedPref.getString("nama", "default").toString()
        if (nama != "default")
            binding.name.setText(nama)

        val dataRefleksiProyek = listOf(
            binding.edtRefleksiproyek1, binding.edtRefleksiproyek2, binding.edtRefleksiproyek3,
            binding.edtRefleksiproyek4, binding.edtRefleksiproyek5, binding.edtRefleksiproyek6,
            binding.edtRefleksiproyek7
        )

        for (i in dataRefleksiProyek.indices) {
            val savedDataRefleksiProyek = sharedPref.getString("dataReflProyek${i + 1}", "default").toString()
            if (savedDataRefleksiProyek != "default") dataRefleksiProyek[i].setText(savedDataRefleksiProyek)
        }

        binding.apply {
            btnNext.setOnClickListener {
                for (i in dataRefleksiProyek.indices) {
                    editor.putString("dataReflProyek${i+1}", dataRefleksiProyek[i].text.toString().trim())
                }
                editor.putString("nama", binding.name.text.toString().trim())
                editor.apply()

                Intent(this@RefleksiProyekActivity, SevenTeenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}