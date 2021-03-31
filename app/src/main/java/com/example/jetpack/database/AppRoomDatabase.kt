package com.example.jetpack.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jetpack.dao.EmpDao

@Database(entities = arrayOf(EmpEntity::class),version = 1)
abstract class RoomAppDb:RoomDatabase() {
    abstract fun empDao():EmpDao

//    companion object {
//        private var INSTANCE: RoomAppDb?= null
//
//        val migration_1_2: Migration = object: Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE userinfo ADD COLUMN phone TEXT DEFAULT ''")
//            }
//        }
//
//        fun getAppDatabase(context: Context): RoomAppDb? {
//
//            if (INSTANCE == null) {
//                synchronized(RoomAppDb::class) {
//                    INSTANCE =
//                        buildRoomDB(context)
//                }
//            }
//            return INSTANCE!!
//        }
//
//
//
//            private fun buildRoomDB(context: Context) =
//                Room.databaseBuilder(
//                    context.applicationContext,
//                    RoomAppDb::class.java,
//                    "roomdbexample"
//                ).fallbackToDestructiveMigration().build()
//
//
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
//    }


}