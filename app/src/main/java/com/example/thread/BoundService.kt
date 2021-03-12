package com.example.thread

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class BoundService:Service() {

    private  val myBinder = LocalBinder()

    fun getCurrentTime():String{
        val dateFormat = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.US)
        return dateFormat.format(Date())
    }


    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }

    class LocalBinder :Binder(){
        fun  getService():BoundService{
            return BoundService()
        }
}



}
