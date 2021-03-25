package com.example.jetpack.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmpTable")
data class EmpEntity (

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,

    @ColumnInfo
    var name:String?= null,
    var address:String?=null,
    var phone:String?=null

){


}