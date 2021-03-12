package com.example.thread

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.provider.Settings.Global.getString
import android.widget.TextView

class BatteryReceiver() : BroadcastReceiver() {

    lateinit var tv: TextView
    var level = "%"
    constructor( tv:TextView):this(){
        this.tv = tv

    }
    override fun onReceive(context: Context?, intent: Intent?) {
        var percentage = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)

       // tv.setText(percentage)

        if (percentage!=0)
        {
            var battery = context!!.getString(R.string.battery)
            tv.setText(battery + ":- " + percentage +"%")
        }

    }
}