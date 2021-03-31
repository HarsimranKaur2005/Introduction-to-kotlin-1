package com.example.jetpack.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.jetpack.database.EmpEntity

@Dao
interface EmpDao {

    @Query("Select * from emptable order by name asc")
    fun getAllEmp(): LiveData<List<EmpEntity>>

    @Insert
    fun insertEmp(empEntity: EmpEntity)

    @Delete
    fun deleteEmp(empEntity: EmpEntity)

    @Update
    fun updateEmp(empEntity: EmpEntity)
}