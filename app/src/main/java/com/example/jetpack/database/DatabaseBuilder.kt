package com.example.jetpack.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseBuilder {
    private var INSTANCE:RoomAppDb?=null




    fun  getInstance(context: Context):RoomAppDb{
        if(INSTANCE == null)
        {
            synchronized(RoomAppDb::class){
                INSTANCE= buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context)=
        Room.databaseBuilder(
            context.applicationContext,
                RoomAppDb::class.java,
            "DB-EMP"
        ).fallbackToDestructiveMigration().build()



}