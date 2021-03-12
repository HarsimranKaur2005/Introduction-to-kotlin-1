package com.example.thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Question3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        var serviceIntent = Intent(applicationContext, MyService::class.java )

        var btnStart = findViewById<Button>(R.id.start_btn)
        btnStart.setOnClickListener(){
            Log.i("test", "button clicked")
            startService(serviceIntent)
        }

        var btnStop = findViewById<Button>(R.id.stop_btn)
        btnStop.setOnClickListener(){
            stopService(serviceIntent)
        }
    }
}