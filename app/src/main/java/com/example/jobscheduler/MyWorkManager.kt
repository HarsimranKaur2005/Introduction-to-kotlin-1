package com.example.jobscheduler

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkManager(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters)
{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {
        createNotification("Background Task", "This is workManager demo")
        return Result.success()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification(title:String, desc:String) {

        //create notification
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationChannel= NotificationChannel("123", "channel",NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(notificationChannel)

        val notificationBar = NotificationCompat.Builder(applicationContext, "123")
            .setContentTitle(title)
            .setContentText(desc)
            .setSmallIcon(R.drawable.ic_launcher_background)


        notificationManager.notify(1, notificationBar.build())

    }

}