package com.fleaudie.besinolcer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class KaloriSonuc : AppCompatActivity() {
    private lateinit var txtSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalorisonuc)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val alinanSonuc = intent.getDoubleExtra("sonuc" , 0.0)
        txtSonuc = findViewById(R.id.txtSonuc)
        txtSonuc.text=alinanSonuc.toString()

    }
}