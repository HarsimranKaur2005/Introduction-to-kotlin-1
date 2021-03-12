package com.example.thread

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    var myService: BoundService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_q1 = findViewById<Button>(R.id.ques1)
        btn_q1.setOnClickListener(){
            val intent = Intent(this, Question1::class.java)
            startActivity(intent)
        }

        val btn_q2 = findViewById<Button>(R.id.ques2)
        btn_q2.setOnClickListener(){
            val intent = Intent(this, Question2::class.java)
            startActivity(intent)
        }

        //Music Player with raw file to play song in background.

        val btn_q3 = findViewById<Button>(R.id.ques3)
        btn_q3.setOnClickListener(){
            val intent = Intent(this, Question3::class.java)
            startActivity(intent)
        }

        val btn_q4 = findViewById<Button>(R.id.ques4)


        // to use local servicefirst we have to bind it
        val intent=Intent(this, BoundService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

        btn_q4.setOnClickListener(){
           val currentTime = myService?.getCurrentTime()
            Toast.makeText(this, "current time is: ${currentTime.toString()}", Toast.LENGTH_SHORT).show()
        }
    }
    private val myConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundService.LocalBinder
            myService = binder.getService()
            isBound= true

        }

    }
}


