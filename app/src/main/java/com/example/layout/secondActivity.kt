package com.example.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val linear = findViewById<Button>(R.id.btn_linear)
        linear.setOnClickListener(){
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val relative = findViewById<Button>(R.id.btn_relative)
        relative.setOnClickListener(){
            val intent = Intent(applicationContext, Relative::class.java)
            startActivity(intent)
        }

        val constraint = findViewById<Button>(R.id.btn_constraint)
        constraint.setOnClickListener(){
            val intent = Intent(applicationContext, Constraint::class.java)
            startActivity(intent)
        }

    }
}