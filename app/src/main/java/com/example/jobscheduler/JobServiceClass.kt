package com.example.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Message
import android.util.Log
import android.widget.Toast
import java.util.logging.Handler

class JobServiceClass : JobService(){

    private var TAG = "ExampleJobService"
    private var jobCancelled = false

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d(TAG, "job started")

        //mJobHandler.sendMessage(Message.obtain(mJobHandler, MainActivity.jobId, params))

        // heavy work should be cover on different thread
        backgroundTask(params)

        return true

    }
    override fun onStopJob(params: JobParameters?): Boolean {

        Log.d(TAG,"Job cancelled before completion")
        //if we want to reschedule in future but if the work
        // is not important and you dont want to reschedule it
        // then return false
        jobCancelled= true
        return true
    }

    private fun backgroundTask(params: JobParameters?) {
        Thread(Runnable {
            kotlin.run {
                for (i in 1..15) {
                    //if job is cancelled then return
                    Log.d(TAG, "RUN: " + i)
                    //Toast.makeText(applicationContext, "run: $i" , Toast.LENGTH_SHORT).show()

                    if (jobCancelled){return@Runnable}

                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                Log.d(TAG, "Job finished")
                jobFinished(params, false)
                //return true
            }
        }).start()
    }
//        android.os.Handler(object : android.os.Handler.Callback {
//            override fun handleMessage(msg: Message): Boolean {
//
//
//            }
//        })

    }


   // val mJobHandler: android.os.Handler =






