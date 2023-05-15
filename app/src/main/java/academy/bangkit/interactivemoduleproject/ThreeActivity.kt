package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityThreeBinding
import android.R
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.ContextUtils.getActivity


class ThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.edtNama.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        binding.edtAbsen.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        binding.edtKelas.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        val nama = sharedPref.getString("nama","default").toString()
        val absen = sharedPref.getString("absen","default").toString()
        val kelas = sharedPref.getString("kelas","default").toString()
        if (nama!= "default")
            binding.edtNama.setText(nama)
        if (absen!= "default")
            binding.edtAbsen.setText(absen)
        if (kelas!= "default")
            binding.edtKelas.setText(kelas)

        binding.btnNext.setOnClickListener {
            Intent(this, FourActivity::class.java).also {
                startActivity(it)
            }
            editor.putString("nama", binding.edtNama.text.toString().trim())
            editor.putString("absen", binding.edtAbsen.text.toString().trim())
            editor.putString("kelas", binding.edtKelas.text.toString().trim())
            editor.apply()
        }

        binding.btnPrev.setOnClickListener {
            Intent(this, TwoActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}