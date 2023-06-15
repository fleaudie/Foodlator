package com.fleaudie.besinolcer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Anasayfa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anasayfa)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val btnHesapla=findViewById<Button>(R.id.btnKaloriHesapla)
        btnHesapla.setOnClickListener {
            val intent = Intent(this,KaloriHesap::class.java)
            startActivity(intent) }

        val btnSut=findViewById<ImageButton>(R.id.btnSut)
        btnSut.setOnClickListener {
            val intent = Intent(this,SutveSutUrunleri::class.java)
            startActivity(intent) }

        val btnMeyve=findViewById<ImageButton>(R.id.btnMeyve)
        btnMeyve.setOnClickListener {
            val intent = Intent(this,MeyveSebzeler::class.java)
            startActivity(intent) }

        val btnSeker=findViewById<ImageButton>(R.id.btnSeker)
        btnSeker.setOnClickListener {
            val intent = Intent(this,CikolataveTatlilar::class.java)
            startActivity(intent) }

        val btnEkmek=findViewById<ImageButton>(R.id.btnEkmek)
        btnEkmek.setOnClickListener {
            val intent = Intent(this,HamurIsleri::class.java)
            startActivity(intent) }

        val btnKuru=findViewById<ImageButton>(R.id.btnKuru)
        btnKuru.setOnClickListener {
            val intent = Intent(this,KuruYemisler::class.java)
            startActivity(intent) }

        val btnEt=findViewById<ImageButton>(R.id.btnEt)
        btnEt.setOnClickListener {
            val intent = Intent(this,EtUrunleri::class.java)
            startActivity(intent) }

        val btnAtistirmalik=findViewById<ImageButton>(R.id.btnCips)
        btnAtistirmalik.setOnClickListener {
            val intent = Intent(this,Atistirmaliklar::class.java)
            startActivity(intent) }

        val btnYemek=findViewById<ImageButton>(R.id.btnYemek)
        btnYemek.setOnClickListener {
            val intent = Intent(this,Yemekler::class.java)
            startActivity(intent) }

        val btnYagli=findViewById<ImageButton>(R.id.btnPizza)
        btnYagli.setOnClickListener {
            val intent = Intent(this,YagliYiyecekler::class.java)
            startActivity(intent) }
    }
}