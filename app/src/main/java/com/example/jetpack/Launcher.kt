package com.example.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launcher.*

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        viewmodel.setOnClickListener(){
            var intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        colorchange.setOnClickListener(){
            var intent= Intent(this, ColorChange::class.java)
            startActivity(intent)
        }


    }
}