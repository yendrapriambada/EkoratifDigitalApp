package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivitySixteenBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SixteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dataMindmap1 = sharedPref.getString("mindmap1", "default").toString()
        val dataMindmap2 = sharedPref.getString("mindmap2", "default").toString()
        val dataMindmap3 = sharedPref.getString("mindmap3", "default").toString()
        val dataMindmap4 = sharedPref.getString("mindmap4", "default").toString()
        val dataMindmap5 = sharedPref.getString("mindmap5", "default").toString()
        val dataMindmap6 = sharedPref.getString("mindmap6", "default").toString()

        if (dataMindmap1 != "default") binding.edtMindmap1.setText(dataMindmap1)
        if (dataMindmap2 != "default") binding.edtMindmap2.setText(dataMindmap2)
        if (dataMindmap3 != "default") binding.edtMindmap3.setText(dataMindmap3)
        if (dataMindmap4 != "default") binding.edtMindmap4.setText(dataMindmap4)
        if (dataMindmap5 != "default") binding.edtMindmap5.setText(dataMindmap5)
        if (dataMindmap6 != "default") binding.edtMindmap6.setText(dataMindmap6)

        binding.apply {
            btnMenu.setOnClickListener {
                editor.putString("mindmap1", binding.edtMindmap1.text.toString().trim())
                editor.putString("mindmap2", binding.edtMindmap2.text.toString().trim())
                editor.putString("mindmap3", binding.edtMindmap3.text.toString().trim())
                editor.putString("mindmap4", binding.edtMindmap4.text.toString().trim())
                editor.putString("mindmap5", binding.edtMindmap5.text.toString().trim())
                editor.putString("mindmap6", binding.edtMindmap6.text.toString().trim())
                editor.apply()

                Intent(this@SixteenActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}