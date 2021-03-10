package com.example.sqlite

import android.os.Build.ID
import androidx.room.*

@Dao
interface EmpDao {

    @Query("Select * from employee_table")
    fun getAllEmployee():List<EmpEntity>

    @Insert
    fun insertEmployee(empEntity: EmpEntity)

    @Query("UPDATE employee_table SET name = :Name, address = :address, phone =:phone WHERE id = :ID")
    fun updateEmployee(ID: Int, Name:String, address:String, phone:String)

    @Delete
    fun deleteEmployee(empEntity: EmpEntity)

    @Query("DELETE from employee_table WHERE name= null")
    fun DeleteAll()

    @Query("DELETE from employee_table WHERE name = :ID" )
    fun deletebyID(ID:Int)


}