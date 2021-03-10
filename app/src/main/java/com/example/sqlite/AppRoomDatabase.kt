package com.example.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EmpEntity::class), version = 3)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun empDao():EmpDao
}