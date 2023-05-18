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

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataIdeProduk = sharedPref.getString("ideProduk", "default").toString()
        val dataJenisUsaha = sharedPref.getString("jenisUsaha", "default").toString()
        val dataUnikProduk = sharedPref.getString("unikProduk", "default").toString()

        if (dataIdeProduk != "default") binding.edt1.setText(dataIdeProduk)
        if (dataJenisUsaha != "default") binding.edt2.setText(dataJenisUsaha)
        if (dataUnikProduk != "default") binding.edt3.setText(dataUnikProduk)

        binding.apply{
            btnPrev.setOnClickListener {
                Intent(this@IdeUsahaActivity, CoverProposalActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnNext.setOnClickListener {
                editor.putString("ideProduk", binding.edt1.text.toString().trim())
                editor.putString("jenisUsaha", binding.edt2.text.toString().trim())
                editor.putString("unikProduk", binding.edt3.text.toString().trim())
                editor.apply()

                Intent(this@IdeUsahaActivity, RencanaUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }

        }
    }
}