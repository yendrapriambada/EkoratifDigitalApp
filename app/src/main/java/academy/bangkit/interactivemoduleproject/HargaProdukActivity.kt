package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityHargaProdukBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HargaProdukActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHargaProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHargaProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyHargaProduk", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edt1, binding.edt2, binding.edt3
        )

        for (i in data.indices){
            val savedData = sharedPref.getString("data${i+1}", "default").toString()
            if (savedData != "default") data[i].setText(savedData)
        }

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@HargaProdukActivity, AnggaranDanaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("data${i+1}", data[i].text.toString().trim())
                }

                editor.apply()

                Intent(this@HargaProdukActivity, BazarCeritaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}