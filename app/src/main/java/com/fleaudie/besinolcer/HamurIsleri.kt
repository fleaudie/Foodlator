package com.fleaudie.besinolcer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HamurIsleri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hamurisleri)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
    }
}