package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityNineTeenBinding
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class NineTeenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNineTeenBinding
    private var one: String = "null"
    private var two: String = "null"
    private var three: String = "null"
    private var four: String = "null"
    private var five: String = "null"
    private var six: String = "null"
    private var seven: String = "null"
    private var eight: String = "null"
    private var nine: String = "null"
    private var ten: String = "null"
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNineTeenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)

        val scoreNow = pref.getInt("score", 0)

        if (scoreNow != 0){
            val intent = Intent(this, TwentyActivity::class.java)
            intent.putExtra("dataScore", scoreNow)
            startActivity(intent)
        }
        binding.apply {
            btnCheckboxBenar.setOnClickListener {
                checklist11.visibility = View.VISIBLE
                checklist12.visibility = View.GONE
                one = "benar"
            }
            btnCheckboxSalah.setOnClickListener {
                checklist11.visibility = View.GONE
                checklist12.visibility = View.VISIBLE
                one = "salah"
            }

            btnBenar2.setOnClickListener {
                checklist21.visibility = View.VISIBLE
                checklist22.visibility = View.GONE
                two = "benar"
            }
            btnSalah2.setOnClickListener {
                checklist21.visibility = View.GONE
                checklist22.visibility = View.VISIBLE
                two = "salah"
            }

            btnBenar3.setOnClickListener {
                checklist31.visibility = View.VISIBLE
                checklist32.visibility = View.GONE
                three = "benar"
            }
            btnSalah3.setOnClickListener {
                checklist31.visibility = View.GONE
                checklist32.visibility = View.VISIBLE
                three = "salah"
            }

            btnBenar4.setOnClickListener {
                checklist41.visibility = View.VISIBLE
                checklist42.visibility = View.GONE
                four = "benar"
            }
            btnSalah4.setOnClickListener {
                checklist41.visibility = View.GONE
                checklist42.visibility = View.VISIBLE
                four = "salah"
            }

            btnBenar5.setOnClickListener {
                checklist51.visibility = View.VISIBLE
                checklist52.visibility = View.GONE
                five = "benar"
            }
            btnSalah5.setOnClickListener {
                checklist51.visibility = View.GONE
                checklist52.visibility = View.VISIBLE
                five = "salah"
            }

            btnBenar6.setOnClickListener {
                checklist61.visibility = View.VISIBLE
                checklist62.visibility = View.GONE
                six = "benar"
            }
            btnSalah6.setOnClickListener {
                checklist61.visibility = View.GONE
                checklist62.visibility = View.VISIBLE
                six = "salah"
            }

            btnBenar7.setOnClickListener {
                checklist71.visibility = View.VISIBLE
                checklist72.visibility = View.GONE
                seven = "benar"
            }
            btnSalah7.setOnClickListener {
                checklist71.visibility = View.GONE
                checklist72.visibility = View.VISIBLE
                seven = "salah"
            }

            btnBenar8.setOnClickListener {
                checklist81.visibility = View.VISIBLE
                checklist82.visibility = View.GONE
                eight = "benar"
            }
            btnSalah8.setOnClickListener {
                checklist81.visibility = View.GONE
                checklist82.visibility = View.VISIBLE
                eight = "salah"
            }


            btnBenar9.setOnClickListener {
                checklist91.visibility = View.VISIBLE
                checklist92.visibility = View.GONE
                nine = "benar"
            }
            btnSalah9.setOnClickListener {
                checklist91.visibility = View.GONE
                checklist92.visibility = View.VISIBLE
                nine = "salah"
            }


            btnBenar10.setOnClickListener {
                checklist101.visibility = View.VISIBLE
                checklist102.visibility = View.GONE
                ten = "benar"
            }
            btnSalah10.setOnClickListener {
                checklist101.visibility = View.GONE
                checklist102.visibility = View.VISIBLE
                ten = "salah"
            }
        }

        binding.btnSubmit.setOnClickListener {
            // validation
            if (this.one == "null" || this.two == "null" || this.three == "null" || this.four == "null" || this.five == "null" || this.six == "null" || this.seven == "null" || this.eight == "null" || this.nine == "null" || this.ten == "null"){
                Toast.makeText(this, "Silahan isi seluruh soal terlebih dahulu.", Toast.LENGTH_SHORT).show()
            }
            else{
                // kunjaw
                if (one == "benar"){
                    score += 10
                }
                if (two == "benar"){
                    score += 10
                }
                if (three == "salah"){
                    score += 10
                }
                if (four == "benar"){
                    score += 10
                }
                if (five == "salah"){
                    score += 10
                }
                if (six == "benar"){
                    score += 10
                }
                if (seven == "salah"){
                    score += 10
                }
                if (eight == "salah"){
                    score += 10
                }
                if (nine == "salah"){
                    score += 10
                }
                if (ten == "benar"){
                    score += 10
                }


                val editor: SharedPreferences.Editor = pref.edit()
                editor.putInt("score", this.score)
                editor.apply()

                val intent = Intent(this, TwentyActivity::class.java)
                startActivity(intent)
            }
        }
        binding.btnMenu.setOnClickListener {
            Intent(this, FiveActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}
