package com.example.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee_table")
data class EmpEntity (

    @PrimaryKey(autoGenerate = true)
    var id:Int=0 ,

     @ColumnInfo
     var name:String?=null,
      var address:String?=null,
    var phone:String?=null
){
}

