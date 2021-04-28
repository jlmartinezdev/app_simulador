package com.jlmartinez.votos2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ventana3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana3)
        var comenzar= findViewById<Button>(R.id.button_sig_v3)
        comenzar.setOnClickListener{
            val intent = Intent(this, ventana4::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivityForResult(intent, 0)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}