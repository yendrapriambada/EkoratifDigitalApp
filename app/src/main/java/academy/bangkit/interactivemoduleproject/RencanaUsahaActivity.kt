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

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataPembeli = sharedPref.getString("pembeliUsaha", "default").toString()
        val dataTempat = sharedPref.getString("tempatUsaha", "default").toString()
        val dataIklan = sharedPref.getString("iklanUsaha", "default").toString()
        val dataNama = sharedPref.getString("namaProduk", "default").toString()

        if (dataPembeli != "default") binding.edt1.setText(dataPembeli)
        if (dataTempat != "default") binding.edt2.setText(dataTempat)
        if (dataIklan != "default") binding.edt3.setText(dataIklan)
        if (dataNama != "default") binding.edt4.setText(dataNama)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@RencanaUsahaActivity, IdeUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                editor.putString("pembeliUsaha", binding.edt1.text.toString().trim())
                editor.putString("tempatUsaha", binding.edt2.text.toString().trim())
                editor.putString("iklanUsaha", binding.edt3.text.toString().trim())
                editor.putString("namaProduk", binding.edt4.text.toString().trim())
                editor.apply()

                Intent(this@RencanaUsahaActivity, AnggaranDanaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}