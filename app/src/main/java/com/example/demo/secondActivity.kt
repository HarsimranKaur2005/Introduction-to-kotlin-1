package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val fragmentOperationbtn = findViewById<Button>(R.id.fragmentoperation)
        val  dialogFragment = findViewById<Button>(R.id.dialogFragment_btn)



        fragmentOperationbtn.setOnClickListener(){
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }



        dialogFragment.setOnClickListener(){
            var dialogfrag = DialogClass()
            dialogfrag.show(supportFragmentManager, "dialogfragment")
        }
    }
}