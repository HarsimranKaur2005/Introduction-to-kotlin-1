package com.example.thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {
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
    }
}