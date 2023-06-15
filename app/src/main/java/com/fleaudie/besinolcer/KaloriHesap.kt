package com.fleaudie.besinolcer

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class KaloriHesap : AppCompatActivity() {
    private lateinit var txtBoy: EditText
    private lateinit var txtYas: EditText
    private lateinit var txtKilo: EditText
    private lateinit var btnHesapla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalorihesap)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val spnCins = findViewById<Spinner>(R.id.spnCinsiyet)
        val itemsCins = arrayOf("Erkek", "Kadın")

        val adapterCins = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsCins) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val textView = view.findViewById<TextView>(android.R.id.text1)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                textView.setTextColor(Color.rgb(251,145,145))
                textView.gravity = Gravity.CENTER
                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view.findViewById<TextView>(android.R.id.text1)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                textView.setTextColor(Color.rgb(251,145,145))
                textView.gravity = Gravity.CENTER
                return view
            }
        }

        adapterCins.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCins.adapter = adapterCins

        val spnAkt = findViewById<Spinner>(R.id.spnAktivite)
        val itemsAkt = arrayOf("Az Aktif", "Orta Aktif", "Çok Aktif") // Eklemek istediğiniz textleri dizi olarak tanımlayın

        val adapterAkt = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsAkt) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val textView = view.findViewById<TextView>(android.R.id.text1)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                textView.setTextColor(Color.rgb(251,145,145))
                textView.gravity = Gravity.CENTER

                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view.findViewById<TextView>(android.R.id.text1)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                textView.setTextColor(Color.rgb(251,145,145))
                textView.gravity = Gravity.CENTER
                return view
            }
        }

        adapterAkt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnAkt.adapter = adapterAkt

        txtBoy = findViewById(R.id.txtBoy)
        txtYas = findViewById(R.id.txtYas)
        txtKilo = findViewById(R.id.txtKilo)
        btnHesapla = findViewById(R.id.btnHesapla)

        btnHesapla.setOnClickListener {
            val sayi1 = txtBoy.text.toString()
            val sayi2 = txtKilo.text.toString()
            val sayi3 = txtYas.text.toString()
            if (sayi1.isNotEmpty() && sayi2.isNotEmpty() && sayi3.isNotEmpty()){
                val num1 = sayi1.toDouble()
                val num2 = sayi2.toDouble()
                val num3 = sayi3.toDouble()

                val sonuc = 66.5 + (13.75 * num2) + (5 * num1) - (6.77 * num3)

                val intent = Intent(this, KaloriSonuc::class.java)
                intent.putExtra("sonuc", sonuc)
                startActivity(intent)
            }

        }
    }
}