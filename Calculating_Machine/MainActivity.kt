package com.example.dev3_hesapmaknes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ekran: TextView
    private var mevcutGirdi = StringBuilder()
    private var birinciSayi: Double = 0.0
    private var ikinciSayi: Double = 0.0
    private var islem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ekran = findViewById(R.id.textView)


        val buton0 = findViewById<Button>(R.id.buttonsıfır)
        val buton1 = findViewById<Button>(R.id.buttonbir)
        val buton2 = findViewById<Button>(R.id.buttoniki)
        val buton3 = findViewById<Button>(R.id.buttonüç)
        val buton4 = findViewById<Button>(R.id.buttondört)
        val buton5 = findViewById<Button>(R.id.buttonbeş)
        val buton6 = findViewById<Button>(R.id.buttonaltı)
        val buton7 = findViewById<Button>(R.id.buttonyedi)
        val buton8 = findViewById<Button>(R.id.buttonsekiz)
        val buton9 = findViewById<Button>(R.id.buttondokuz)


        val butonToplama = findViewById<Button>(R.id.buttontoplama)
        val butonCikarma = findViewById<Button>(R.id.buttonçıkarma)
        val butonCarpma = findViewById<Button>(R.id.buttonçarpma)
        val butonBolme = findViewById<Button>(R.id.buttonbölme)
        val butonEsittir = findViewById<Button>(R.id.buttoneşittir)
        val butonTemizle = findViewById<Button>(R.id.buttondelete)

        buton0.setOnClickListener { girdiEkle("0") }
        buton1.setOnClickListener { girdiEkle("1") }
        buton2.setOnClickListener { girdiEkle("2") }
        buton3.setOnClickListener { girdiEkle("3") }
        buton4.setOnClickListener { girdiEkle("4") }
        buton5.setOnClickListener { girdiEkle("5") }
        buton6.setOnClickListener { girdiEkle("6") }
        buton7.setOnClickListener { girdiEkle("7") }
        buton8.setOnClickListener { girdiEkle("8") }
        buton9.setOnClickListener { girdiEkle("9") }


        butonToplama.setOnClickListener { islemBelirle("+") }
        butonCikarma.setOnClickListener { islemBelirle("-") }
        butonCarpma.setOnClickListener { islemBelirle("*") }
        butonBolme.setOnClickListener { islemBelirle("/") }


        butonEsittir.setOnClickListener { sonucHesapla() }


        butonTemizle.setOnClickListener { girdiTemizle() }
    }


    private fun girdiEkle(deger: String) {
        mevcutGirdi.append(deger)
        ekran.text = mevcutGirdi.toString()
    }


    private fun islemBelirle(op: String) {
        if (mevcutGirdi.isNotEmpty()) {
            birinciSayi = mevcutGirdi.toString().toDouble()
            islem = op
            mevcutGirdi.append(op)
            ekran.text = mevcutGirdi.toString()
        }
    }


    private fun sonucHesapla() {
        if (mevcutGirdi.isNotEmpty()) {
            val parcalar = mevcutGirdi.toString().split(Regex("([+*/-])"))
            if (parcalar.size == 2) {
                ikinciSayi = parcalar[1].toDouble()
                birinciSayi = parcalar[0].toDouble()
                val sonuc = when (islem) {
                    "+" -> birinciSayi + ikinciSayi
                    "-" -> birinciSayi - ikinciSayi
                    "*" -> birinciSayi * ikinciSayi
                    "/" -> if (ikinciSayi != 0.0) birinciSayi / ikinciSayi else "Hata"
                    else -> 0.0
                }
                ekran.text = "$sonuc"
            }
            mevcutGirdi.clear()
        }
    }

    private fun girdiTemizle() {
        mevcutGirdi.clear()
        ekran.text = ""
        birinciSayi = 0.0
        ikinciSayi = 0.0
        islem = ""
    }
}
