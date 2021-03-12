package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.Thread.currentThread


//Use start() join() and sleep() methods in single program to execute different threads.

class Question1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        var th = MyThread(1)
        th.start()
        println("Invoking join")
        th.join()
        println("Returned from join")


    }


}
class MyThread() : Thread() {


    var processCount = 0

    constructor(processCount: Int) : this() {
        this.processCount = processCount
        println("Thread Created")

    }

    override fun run() {
        println("Thread " + this.name + " started")

        while (processCount > 0) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                println("Thread " + this.name + " interrupted")
            }
            processCount--
        }
        println("Thread " + this.name + " exiting")
    }

}