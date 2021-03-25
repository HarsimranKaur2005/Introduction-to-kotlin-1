package com.example.jetpack.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpack.dao.EmpDao
import com.example.jetpack.database.DatabaseBuilder

import com.example.jetpack.database.EmpEntity
import java.util.concurrent.Executors

class EmpRepo() {

    lateinit var empDao: EmpDao
    lateinit var allEmp: MutableLiveData<List<EmpEntity>>

    /*
    Constructor that receives an Application context and
    instantiates a database class, getting the Dao that will
    be needed from it to store in the empDao variable
     */

//    constructor(context: Context):this(){
//        var db = DatabaseBuilder.getInstance(context)
//        empDao = db.empDao()
//        allEmp = empDao.getAllEmp()
//    }

    fun insert(empEntity: EmpEntity){
        insertInNewThread(empEntity)
    }

    private fun insertInNewThread(empEntity: EmpEntity) {
        Executors.newSingleThreadExecutor().execute {
            empDao.insertEmp(empEntity)

        }
    }

    fun getAllEmpData(): MutableLiveData<List<EmpEntity>>{
        return allEmp
    }

}