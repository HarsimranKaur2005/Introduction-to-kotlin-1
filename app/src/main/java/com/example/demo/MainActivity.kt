package com.example.demo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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