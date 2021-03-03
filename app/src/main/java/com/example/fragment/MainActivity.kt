package com.example.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //QUESTION 1:- OBERSERVE LIFECYCLE OF FRAGMENT
        //WITH ACTIVITY

        var btn_fragmentOperation = findViewById<Button>(R.id.fragmentoperation)

        btn_fragmentOperation.setOnClickListener() {
             val intent = Intent(applicationContext, secondActivity::class.java)
            startActivity(intent)

        }

        val btn_dialog = findViewById<Button>(R.id.dialogFragment_btn)
        btn_dialog.setOnClickListener(){
            var dialogfrag = Dialog()
            dialogfrag.show(supportFragmentManager, "dialogfragment")
        }



        val btn_pref = findViewById<Button>(R.id.preference_btn)
        btn_pref.setOnClickListener(){

            val intent = Intent(applicationContext, thirdActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("Activity-LIFE_CYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Activity-LIFE_CYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Activity-LIFE_CYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Activity-LIFE_CYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Activity-LIFE_CYCLE", "onDestroy")
    }
}