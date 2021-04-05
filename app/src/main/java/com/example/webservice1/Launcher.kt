package com.example.webservice1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        fibanacci.setOnClickListener(){
            GlobalScope.launch {
                fibanacciSeries(10)
            }
            Thread.sleep(10000L)

        }

        coroutine.setOnClickListener(){
            var intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        async.setOnClickListener(){
            var intent  = Intent(this, AsyncActivity::class.java)
            startActivity(intent)
        }
    }

    private suspend fun fibanacciSeries(input:Int){
        var n1 = 0
        var n2 =1
        var n3:Int?=0

        for (i in 2..input)
        {
            n3=n1+n2
            println(" ${n1+n2}")
            n1=n2
            n2=n3
            delay(300)
        }
    }
}

