package com.example.enlacesatelital

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SatelliteDown : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.satellite_down)
        initButtons()
    }

    private fun initButtons(){
        val returnButton = findViewById<Button>(R.id.returnDownButton)
        val restartButton = findViewById<Button>(R.id.restartDownButton)

        returnButton.setOnClickListener {
            returnActivity( this)
        }

        restartButton.setOnClickListener{
            resetActivity(this)
        }
    }

    private fun resetActivity(activity: Activity){
        val intent = Intent().setClass(this, activity.javaClass)
        activity.startActivity(intent)
        activity.finish()
    }

    private fun returnActivity(activity: Activity){
        activity.finish()
    }

}