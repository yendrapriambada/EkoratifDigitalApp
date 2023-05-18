package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityLatihanEkonomiBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LatihanEkonomiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLatihanEkonomiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanEkonomiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataProduksi = sharedPref.getString("defProduksi", "default").toString()
        val dataDistribusi = sharedPref.getString("defDistribusi", "default").toString()
        val dataKonsumsi = sharedPref.getString("defKonsumsi", "default").toString()
        val dataContohKegiatan = sharedPref.getString("contohKegiatan", "default").toString()

        if (dataProduksi != "default")
            binding.edtProduksi.setText(dataProduksi)
        if (dataDistribusi != "default")
            binding.edtDistribusi.setText(dataDistribusi)
        if (dataKonsumsi != "default")
            binding.edtKonsumsi.setText(dataKonsumsi)
        if (dataContohKegiatan != "default")
            binding.edtContohekonomi.setText(dataContohKegiatan)

        binding.btnMenu.setOnClickListener {
            editor.putString("defProduksi", binding.edtProduksi.text.toString().trim())
            editor.putString("defDistribusi", binding.edtDistribusi.text.toString().trim())
            editor.putString("defKonsumsi", binding.edtKonsumsi.text.toString().trim())
            editor.putString("contohKegiatan", binding.edtContohekonomi.text.toString().trim())
            editor.apply()
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}