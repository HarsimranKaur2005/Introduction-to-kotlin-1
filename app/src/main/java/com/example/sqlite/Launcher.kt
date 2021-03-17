package com.example.sqlite

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.jar.Manifest

class Launcher : AppCompatActivity() {
    val contactHashMap = HashMap<String,String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        var btnRoom = findViewById<Button>(R.id.btn_room)

       btnRoom.setOnClickListener(){

            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }


}