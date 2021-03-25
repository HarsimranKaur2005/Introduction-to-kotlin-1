package com.example.jetpack.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.database.DatabaseBuilder

import com.example.jetpack.database.EmpEntity
import com.example.jetpack.database.RoomAppDb
import com.example.jetpack.repository.EmpRepo

class EmpViewModel(application: Application):AndroidViewModel(application) {
    lateinit var repo:EmpRepo

  //  var db = DatabaseBuilder.getInstance(context )
    lateinit var allEmp:MutableLiveData<List<EmpEntity>>

    init {
        allEmp = MutableLiveData()
        getAllEmployee()
    }

//    constructor(application: Application):this(){
//      repo = EmpRepo(application)
//        allEmp = repo.getAllEmpData()
//
//    }

   public fun getAllEmpObserver():MutableLiveData<List<EmpEntity>>{
 return allEmp}

//    fun insert(empEntity: EmpEntity){
////        db.empDao().insertEmp(EmpEntity(1,"simran", "delhi", "1223"))
////        db.empDao().insertEmp(EmpEntity(2,"simran", "delhi", "1223"))
////        db.empDao().insertEmp(EmpEntity(1,"simran", "delhi", "1223"))
////        db.empDao().insertEmp(EmpEntity(1,"simran", "delhi", "1223"))
////        db.empDao().insertEmp(EmpEntity(1,"simran", "delhi", "1223"))
////        db.empDao().insertEmp(EmpEntity(1,"simran", "delhi", "1223"))
//
//
//        repo.insert(empEntity)
//    }

    fun getAllEmployee(){
        var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()


        val list = dao?.getAllEmp()

        allEmp.postValue(list!!)
    }


    fun InsertemployeeData(empEntity: EmpEntity){
        var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()
        dao!!.insertEmp(empEntity)
        getAllEmployee()
    }

    fun UpdateEmployee(empEntity: EmpEntity){
        var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()

        dao!!.updateEmp(empEntity)
        getAllEmployee()
    }

    fun DeleteEmployee(empEntity: EmpEntity){
       var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()

        //var dao = repo.insert(empEntity)
        dao!!.deleteEmp(empEntity)
        getAllEmployee()
    }
}