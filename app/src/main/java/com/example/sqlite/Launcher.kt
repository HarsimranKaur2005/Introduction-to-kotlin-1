package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        var btnRoom = findViewById<Button>(R.id.btn_room)
        var btnContentProvider = findViewById<Button>(R.id.btn_contentProvider)

       btnRoom.setOnClickListener(){

            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        btnContentProvider.setOnClickListener(){

        }
    }
}