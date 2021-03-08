package com.example.storagepart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Make an application with one edit text, Two buttons(Submit & retrieve) and one textview .
//        On clicking the Submit button data provided in the edit text should be stored in shared preferences
//        and on clicking the retrieve button data should be retrieved from the shared preferences
//        and get set on the text view provided.
        val btn_sharedpref = findViewById<Button>(R.id.sharedpref)
        btn_sharedpref.setOnClickListener(){
            val intent = Intent(applicationContext,sharedpref::class.java)
            startActivity(intent)
        }


        val btn_internal = findViewById<Button>(R.id.internalStorage)
        btn_internal.setOnClickListener()
        {
            val intent = Intent(applicationContext,FileHandling::class.java)
            startActivity(intent)
        }
    }
}