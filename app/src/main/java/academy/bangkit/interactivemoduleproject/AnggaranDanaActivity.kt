package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityAnggaranDanaBinding
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AnggaranDanaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnggaranDanaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnggaranDanaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyAnggaranDana", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val others = listOf(
            binding.edt2, binding.edt3
        )

        for (i in others.indices){
            val dataOthers = sharedPref.getString("other${i+1}", "default").toString()
            if (dataOthers != "default") others[i].setText(dataOthers)
        }

        val editTexts = listOf(
            binding.edtNamabarang1, binding.edtNamabarang2, binding.edtNamabarang3,
            binding.edtNamabarang4, binding.edtNamabarang5, binding.edtNamabarang6
        )

        val quantities = listOf(
            binding.edtJumlah1, binding.edtJumlah2, binding.edtJumlah3,
            binding.edtJumlah4, binding.edtJumlah5, binding.edtJumlah6
        )

        val prices = listOf(
            binding.edtHarga1, binding.edtHarga2, binding.edtHarga3,
            binding.edtHarga4, binding.edtHarga5, binding.edtHarga6
        )

        val totalPrices = listOf(
            binding.tvJumlahharga1, binding.tvJumlahharga2, binding.tvJumlahharga3,
            binding.tvJumlahharga4, binding.tvJumlahharga5, binding.tvJumlahharga6
        )

        // Initialize total prices and total modal
        for (i in editTexts.indices) {
            val quantity = sharedPref.getString("quantity${i+1}", "default").toString()
            val price = sharedPref.getString("hargaBarang${i+1}", "default").toString()
            val totalPrice = multipleNumber(quantity, price)
            totalPrices[i].text = totalPrice
        }
        binding.tvTotalModal.text = totalModal(totalPrices)

        for (i in editTexts.indices) {
            val dataNamaBarang = sharedPref.getString("namaBarang${i+1}", "default").toString()
            if (dataNamaBarang != "default") editTexts[i].setText(dataNamaBarang)

            val dataQuantity = sharedPref.getString("quantity${i+1}", "default").toString()
            if (dataQuantity != "default") quantities[i].setText(dataQuantity)

            val dataHargaBarang = sharedPref.getString("hargaBarang${i+1}", "default").toString()
            if (dataHargaBarang != "default") prices[i].setText(dataHargaBarang)

            quantities[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    totalPrices[i].text = multipleNumber(quantities[i].text.toString(), prices[i].text.toString())
                    binding.tvTotalModal.text = totalModal(totalPrices)
                }

                override fun afterTextChanged(s: Editable) {}
            })

            prices[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    totalPrices[i].text = multipleNumber(quantities[i].text.toString(), prices[i].text.toString())
                    binding.tvTotalModal.text = totalModal(totalPrices)
                }

                override fun afterTextChanged(s: Editable) {}
            })
        }

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@AnggaranDanaActivity, RencanaUsahaActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                for (i in editTexts.indices) {
                    editor.putString("namaBarang${i+1}", editTexts[i].text.toString().trim())
                    editor.putString("quantity${i+1}", quantities[i].text.toString().trim())
                    editor.putString("hargaBarang${i+1}", prices[i].text.toString().trim())
                }
                for (i in others.indices) {
                    editor.putString("other${i+1}", others[i].text.toString().trim())
                }

                editor.apply()

                Intent(this@AnggaranDanaActivity, HargaProdukActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }

    private fun multipleNumber(quantity: String, price: String): String {
        val qty = quantity.toIntOrNull() ?: 0
        val prc = price.toIntOrNull() ?: 0
        return (qty * prc).toString()
    }

    private fun totalModal(totalPrices: List<TextView>): String {
        var sum = 0
        for (textView in totalPrices) {
            val totalPrice = textView.text.toString().toIntOrNull() ?: 0
            sum += totalPrice
        }
        return sum.toString()
    }
}