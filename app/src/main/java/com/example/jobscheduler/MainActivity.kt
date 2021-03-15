package com.example.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.solver.state.State
import androidx.lifecycle.Observer
import androidx.work.*

class MainActivity : AppCompatActivity() {

    private var TAG = "MainActivity"
    companion object{
        const val jobId = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startJob = findViewById<Button>(R.id.scheduleJob)
        startJob.setOnClickListener(){
            startJobScheduler()
        }

        var stopJob=findViewById<Button>(R.id.cancelJob)
        stopJob.setOnClickListener(){
            stopJobScheduler()
        }



        //constraints to create notification when the phone is charged and
        //is connected to internet

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()


        //which class should be executed is decided by this rqst obj

        val request = OneTimeWorkRequestBuilder<MyWorkManager>().setConstraints(constraints).build()
        val workbtn = findViewById<Button>(R.id.getNotification)
        workbtn.setOnClickListener(){
            WorkManager.getInstance(this).enqueue(request)// enqueues and manages work reqst
        }

        //creating a toast to display the status of the task
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
            .observe(this, Observer {
                val status = it.state.name
                Toast.makeText(this, "$status", Toast.LENGTH_SHORT).show()
            })
    }

    private fun stopJobScheduler() {
        var jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.cancel(123)
        Log.d(TAG, "job Cancelled")
    }

    private fun startJobScheduler() {
       // Toast.makeText(this, "Job will start in 2 seconds....", Toast.LENGTH_SHORT).show()
        var componentName = ComponentName(this , JobServiceClass::class.java)
        var info = JobInfo.Builder(123, componentName)
             // is pluged in or charged
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) //wifi conneced
            .setPersisted(true) // keep it alive even if phone is rebooted
            .setPeriodic(15*60*1000)
            .build()

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        var resultCode = jobScheduler.schedule(info)
        if (resultCode == JobScheduler.RESULT_SUCCESS){
            Log.d(TAG, "Job scheduled")
        }else{
            Log.d(TAG, "Job scheduling failed")
        }

         }
    }


