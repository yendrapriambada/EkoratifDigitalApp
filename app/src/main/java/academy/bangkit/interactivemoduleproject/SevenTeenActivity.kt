package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFifteenBinding
import academy.bangkit.interactivemoduleproject.databinding.ActivitySevenTeenBinding
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SevenTeenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySevenTeenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySevenTeenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.edtSatupertanyaan.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        binding.edtDuatemuan.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        binding.edtTigahal.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        val satupertanyaan = sharedPref.getString("satupertanyaan","default").toString()
        val duatemuan = sharedPref.getString("duatemuan","default").toString()
        val tigahal= sharedPref.getString("tigahal","default").toString()

        if (satupertanyaan!= "default")
            binding.edtSatupertanyaan.setText(satupertanyaan)
        if (duatemuan!= "default")
            binding.edtDuatemuan.setText(duatemuan)
        if (tigahal!= "default")
            binding.edtTigahal.setText(tigahal)

        binding.btnNext.setOnClickListener {
            editor.putString("satupertanyaan", binding.edtSatupertanyaan.text.toString().trim())
            editor.putString("duatemuan", binding.edtDuatemuan.text.toString().trim())
            editor.putString("tigahal", binding.edtTigahal.text.toString().trim())
            editor.apply()
            Intent(this, EighteenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}