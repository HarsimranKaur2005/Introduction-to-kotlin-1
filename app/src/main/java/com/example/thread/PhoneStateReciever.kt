package com.example.thread

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast
import java.lang.Exception

class PhoneStateReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            println("Receiver start")
            //state will have the state of the phone
            // (whether the phone isin ringing state or off hook or idle state )
            // as string object by using telephony manager
           var state = intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context, "Incoming call state", Toast.LENGTH_SHORT).show()
            }

            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context, " call Received state", Toast.LENGTH_SHORT).show()
            }

            if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context, "call Idle state", Toast.LENGTH_SHORT).show()
            }


        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
}