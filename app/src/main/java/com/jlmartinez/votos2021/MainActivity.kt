package com.jlmartinez.votos2021

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var comenzar= findViewById<Button>(R.id.buttoncomenzar)
        comenzar.setOnClickListener{

            val intent = Intent(this, ventana2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivityForResult(intent, 0)
            overridePendingTransition(0, 0)
            finish()
        }
        val expirationDate: Calendar = Calendar.getInstance()
        expirationDate.set(2021, 7, 15) //expirara final de año

        val t: Calendar = Calendar.getInstance() //obtener fecha actual

        if (t.compareTo(expirationDate) === 1) finish()
    }

    override fun onResume() {
        super.onResume()
        val expirationDate: Calendar = Calendar.getInstance()
        expirationDate.set(2021, 7, 15) //expirara final de año

        val t: Calendar = Calendar.getInstance() //obtener fecha actual

        if (t.compareTo(expirationDate) === 1) finish()
    }
}