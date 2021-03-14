package com.example.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EmpEntity::class), version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun empDao():EmpDao
}