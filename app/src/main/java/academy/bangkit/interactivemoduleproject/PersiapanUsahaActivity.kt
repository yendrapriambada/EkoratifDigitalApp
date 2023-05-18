package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityPersiapanUsahaBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PersiapanUsahaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersiapanUsahaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersiapanUsahaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPersiapanUsaha", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataKegiatan = listOf(
            binding.edtKegiatan1, binding.edtKegiatan2, binding.edtKegiatan3, binding.edtKegiatan4,
            binding.edtKegiatan5, binding.edtKegiatan6, binding.edtKegiatan7, binding.edtKegiatan8
        )

        val dataTanggal = listOf(
            binding.edtTanggal1, binding.edtTanggal2, binding.edtTanggal3, binding.edtTanggal4,
            binding.edtTanggal5, binding.edtTanggal6, binding.edtTanggal7, binding.edtTanggal8
        )

        val dataAnggota = listOf(
            binding.edtAnggota1, binding.edtAnggota2, binding.edtAnggota3, binding.edtAnggota4,
            binding.edtAnggota5, binding.edtAnggota6, binding.edtAnggota7, binding.edtAnggota8
        )

        for (i in dataKegiatan.indices) {
            val savedDataKegiatan = sharedPref.getString("dataKegiatan${i + 1}", "default").toString()
            if (savedDataKegiatan != "default") dataKegiatan[i].setText(savedDataKegiatan)

            val savedDataTanggal = sharedPref.getString("dataTanggal${i + 1}", "default").toString()
            if (savedDataTanggal != "default") dataTanggal[i].setText(savedDataTanggal)

            val savedDataAnggota = sharedPref.getString("dataAnggota${i + 1}", "default").toString()
            if (savedDataAnggota != "default") dataAnggota[i].setText(savedDataAnggota)
        }

        binding.apply {
            btnPrev.setOnClickListener {
                for (i in dataKegiatan.indices) {
                    editor.putString("dataKegiatan${i+1}", dataKegiatan[i].text.toString().trim())
                    editor.putString("dataTanggal${i+1}", dataTanggal[i].text.toString().trim())
                    editor.putString("dataAnggota${i+1}", dataAnggota[i].text.toString().trim())
                }

                editor.apply()

                Intent(this@PersiapanUsahaActivity, BazarCeritaActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnMenu.setOnClickListener {
                for (i in dataKegiatan.indices) {
                    editor.putString("dataKegiatan${i+1}", dataKegiatan[i].text.toString().trim())
                    editor.putString("dataTanggal${i+1}", dataTanggal[i].text.toString().trim())
                    editor.putString("dataAnggota${i+1}", dataAnggota[i].text.toString().trim())
                }

                editor.apply()

                Intent(this@PersiapanUsahaActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}