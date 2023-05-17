package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityEvaluasiBinding
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class EvaluasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEvaluasiBinding
    private var soal: ArrayList<String> = ArrayList()
    private var opsi1: ArrayList<String> = ArrayList()
    private var opsi2: ArrayList<String> = ArrayList()
    private var opsi3: ArrayList<String> = ArrayList()
    private var opsi4: ArrayList<String> = ArrayList()
    private var jawaban: ArrayList<String> = ArrayList()
    private var jawabanUser: ArrayList<String> = ArrayList()
    private var score: Float = 0f
    private var indexSoal = 0
    private lateinit var pref: SharedPreferences
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvaluasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)

        val scoreNow = pref.getInt("scoreEvaluasi", -1)

        if (scoreNow != -1) {
            val intent = Intent(this@EvaluasiActivity, TwentyActivity::class.java)
            intent.putExtra("from", "scoreEvaluasi")
            startActivity(intent)
            finish()
        }

        val soalArray = resources.getStringArray(R.array.questions)
        val optionsAArray = resources.getStringArray(R.array.optionA)
        val optionsBArray = resources.getStringArray(R.array.optionB)
        val optionsCArray = resources.getStringArray(R.array.optionC)
        val optionsDArray = resources.getStringArray(R.array.optionD)
        val jawabanArray = resources.getStringArray(R.array.jawaban)
        soal = ArrayList<String>(soalArray.toList())
        opsi1 = ArrayList<String>(optionsAArray.toList())
        opsi2 = ArrayList<String>(optionsBArray.toList())
        opsi3 = ArrayList<String>(optionsCArray.toList())
        opsi4 = ArrayList<String>(optionsDArray.toList())
        jawaban = ArrayList<String>(jawabanArray.toList())

        showDataLayout()

        binding.apply {
            btnOpsiA.setOnClickListener {
                jawabanUser.add("a")
                quizAlgorithm()
            }
            btnOpsiB.setOnClickListener {
                jawabanUser.add("b")
                quizAlgorithm()
            }
            btnOpsiC.setOnClickListener {
                jawabanUser.add("c")
                quizAlgorithm()
            }
            btnOpsiD.setOnClickListener {
                jawabanUser.add("d")
                quizAlgorithm()
            }
            btnSubmit.setOnClickListener {
                val skorEssay1 = edtNilaiessay1.text.toString().lowercase().trim()
                val skorEssay2 = edtNilaiessay2.text.toString().lowercase().trim()

                logicScore(skorEssay1, skorEssay2)
            }
        }
    }

    private fun logicScore(skorEssay1: String, skorEssay2: String) {
        showLoading()

        // Hitung Skor
        val skorPG = score.toInt()
        val skorEssay = skorEssay1.toInt() + skorEssay2.toInt()
        val totalScore = skorPG + skorEssay
        val finalScore = totalScore * 5

        // Save Data Local
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putInt("scoreEvaluasi", finalScore)
        editor.putInt("scorePG", skorPG)
        editor.putInt("scoreEssay", skorEssay)
        editor.apply()


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@EvaluasiActivity, TwentyActivity::class.java)
            intent.putExtra("from", "scoreEvaluasi")
            startActivity(intent)
            finish()
        }, 1000)
    }

    private fun quizAlgorithm() {
        hideDataLayout()
        showLoading()

        Log.e("index", indexSoal.toString())
        Log.e("jawabanUser", jawabanUser[indexSoal])
        Log.e("jawaban", jawaban[indexSoal])

        // check jawaban
        if (jawabanUser[indexSoal] == jawaban[indexSoal].lowercase(Locale.getDefault())) {
            score += 2f
        }

        indexSoal++

        if (indexSoal >= soal.size) {
            showDataLayoutEssay()
            hideLoading()
        } else {
            showDataLayout()
            hideLoading()
        }
    }

    private fun showDataLayout() {
        binding.apply {
            soalPertanyaan.text = soal[indexSoal]
            val soalPertanyaan =
                ObjectAnimator.ofFloat(binding.soalPertanyaan, View.ALPHA, 1f).setDuration(150)

            btnOpsiA.text = opsi1[indexSoal]
            btnOpsiA.isClickable = true
            val opt_red = ObjectAnimator.ofFloat(binding.btnOpsiA, View.ALPHA, 1f).setDuration(150)

            btnOpsiB.text = opsi2[indexSoal]
            btnOpsiB.isClickable = true
            val opt_yellow =
                ObjectAnimator.ofFloat(binding.btnOpsiB, View.ALPHA, 1f).setDuration(150)

            btnOpsiC.text = opsi3[indexSoal]
            btnOpsiC.isClickable = true
            val opt_green =
                ObjectAnimator.ofFloat(binding.btnOpsiC, View.ALPHA, 1f).setDuration(150)

            btnOpsiD.text = opsi4[indexSoal]
            btnOpsiD.isClickable = true
            val opt_blue = ObjectAnimator.ofFloat(binding.btnOpsiD, View.ALPHA, 1f).setDuration(150)

            AnimatorSet().apply {
                playSequentially(
                    soalPertanyaan,
                    opt_red,
                    opt_yellow,
                    opt_green,
                    opt_blue,
                )
                start()
            }
        }
    }

    private fun showDataLayoutEssay() {
        binding.apply {
            binding.edtEssay1.isEnabled = true
            binding.edtEssay2.isEnabled = true
            binding.edtNilaiessay1.isEnabled = true
            binding.edtNilaiessay2.isEnabled = true
            btnSubmit.isClickable = true
            tvEvaluasi.text = getString(R.string.instruksi_essay)

            soalPertanyaan.text = getString(R.string.questions_essay_1)
            soalPertanyaan2.text = getString(R.string.questions_essay_2)

            val soalPertanyaan =
                ObjectAnimator.ofFloat(binding.soalPertanyaan, View.ALPHA, 1f).setDuration(150)

            val edtJawaban =
                ObjectAnimator.ofFloat(binding.edtEssay1, View.ALPHA, 1f).setDuration(150)

            val edtNilai1 =
                ObjectAnimator.ofFloat(binding.edtNilaiessay1, View.ALPHA, 1f).setDuration(150)

            val soalPertanyaan2 =
                ObjectAnimator.ofFloat(binding.soalPertanyaan2, View.ALPHA, 1f).setDuration(150)

            val edtJawaban2 =
                ObjectAnimator.ofFloat(binding.edtEssay2, View.ALPHA, 1f).setDuration(150)

            val edtNilai2 =
                ObjectAnimator.ofFloat(binding.edtNilaiessay2, View.ALPHA, 1f).setDuration(150)

            val btnSubmit =
                ObjectAnimator.ofFloat(binding.btnSubmit, View.ALPHA, 1f).setDuration(150)


            AnimatorSet().apply {
                playSequentially(
                    soalPertanyaan,
                    edtJawaban,
                    edtNilai1,
                    soalPertanyaan2,
                    edtJawaban2,
                    edtNilai2,
                    btnSubmit
                )
                start()
            }
        }
    }

    private fun hideDataLayout() {
        binding.apply {
            soalPertanyaan.alpha = 0f

            btnOpsiA.alpha = 0f
            btnOpsiA.isClickable = false

            btnOpsiB.alpha = 0f
            btnOpsiB.isClickable = false

            btnOpsiC.alpha = 0f
            btnOpsiC.isClickable = false

            btnOpsiD.alpha = 0f
            btnOpsiD.isClickable = false
        }
    }

    private fun showLoading() {
        progressDialog = ProgressDialog.show(this, "", "Loading...", true)
    }

    private fun hideLoading() {
        progressDialog?.dismiss()
    }
}