package com.example.thread

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

////Register receiver  for incoming calls and battery status.

class Question2 : AppCompatActivity() {
    lateinit var tv :TextView
    lateinit var batteryReceiver: BatteryReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        //ask for permission to make calls
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_PHONE_STATE)
        != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE), 1)


        //battery receiver
        tv=findViewById(R.id.batteryReceiver)
        batteryReceiver = BatteryReceiver(tv)

    }

    override fun onStart() {
        super.onStart()
        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onStop() {
        unregisterReceiver(batteryReceiver)
        super.onStop()
    }

}