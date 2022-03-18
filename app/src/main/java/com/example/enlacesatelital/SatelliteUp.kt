package com.example.enlacesatelital

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.satellite_up.*
import kotlin.math.PI

class SatelliteUp  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.satellite_up)
        initButtons()
    }

    private fun initButtons(){
        val returnButton = findViewById<Button>(R.id.returnUpButton)
        val restartButton = findViewById<Button>(R.id.restartUpButton)

        returnButton.setOnClickListener {
            returnActivity( this)
        }

        restartButton.setOnClickListener{
            resetActivity(this)
        }

        calculateUpButton.setOnClickListener {
            degreeElevation()
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

    private fun degreeElevation(){
        val degreeLUp = findViewById<EditText>(R.id.degreeLUp)
        val minuteLUp = findViewById<EditText>(R.id.minuteLUp)
        val minuteLongUp = findViewById<EditText>(R.id.minuteLongUp)
        val degreeLongUp = findViewById<EditText>(R.id.degreeLongUp)
        val longSatUp = findViewById<EditText>(R.id.longSatUp)
        val degreeElevationUp = findViewById<EditText>(R.id.degreeElevationUp)

        var decimalLUp = degreeLUp.text.toString().toFloat() + (minuteLUp.text.toString().toFloat()/60)
        var decimalLongUp = degreeLongUp.text.toString().toFloat() + (minuteLongUp.text.toString().toFloat()/60)
        val c = Math.cos(decimalLUp.toDouble()*PI/180)*Math.cos(longSatUp.text.toString().toDouble()*PI/180 - decimalLongUp.toDouble()*PI/180)
        val thetaOne = Math.acos(c)
        val theta = Math.atan((c - 0.15127)/(Math.sin(thetaOne)))
        degreeElevationUp.setText((theta*180F/PI).toString())

        val d = 35786*Math.sqrt(1.4199 - 0.4199* Math.cos(thetaOne))
        distanceUp.setText(d.toString())

        val lOne = Math.pow(((4*Math.PI*d*Math.pow(10.0, 3.0)*frequencyUp.text.toString().toFloat())/(3*Math.pow(10.0,8.0))), 2.0)
        val lp = 10*Math.log10(lOne)
        propagationUp.setText(lp.toString())

        
    }

}