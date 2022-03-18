package com.example.enlacesatelital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButtons()
    }

    private fun initButtons(){
        val buttonUp = findViewById<Button>(R.id.sateliteUpButon)
        val buttonDown = findViewById<Button>(R.id.sateliteDownButon)

        buttonUp.setOnClickListener{
            val intent = Intent(this, SatelliteUp::class.java)
            startActivity(intent)
        }

        buttonDown.setOnClickListener {
            val intent = Intent(this, SatelliteDown::class.java)
            startActivity(intent)
        }
    }
}