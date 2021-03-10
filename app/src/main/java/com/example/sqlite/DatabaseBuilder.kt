package com.example.sqlite

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    private var INSTANCE:AppRoomDatabase?=null

    fun getInstance(context: Context): AppRoomDatabase {
        if (INSTANCE == null) {
            synchronized(AppRoomDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppRoomDatabase::class.java,
            "roomdbexample"
        ).fallbackToDestructiveMigration().build()
}