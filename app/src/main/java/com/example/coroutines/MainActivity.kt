package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        fibanacci.setOnClickListener(){
           GlobalScope.launch {
                fibanacciSeries(10)
            }
            Thread.sleep(10000L)

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