package com.fleaudie.besinolcer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MeyveSebzeler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meyvesebzeler)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
    }
}