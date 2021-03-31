package com.example.jetpack.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.jetpack.database.DatabaseBuilder

import com.example.jetpack.database.EmpEntity
import com.example.jetpack.database.RoomAppDb
import com.example.jetpack.repository.EmpRepo
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class EmpViewModel(application: Application):AndroidViewModel(application) {

private val context= getApplication<Application>().applicationContext

    lateinit var allEmp: LiveData<List<EmpEntity>>
    val roomDatabase =  DatabaseBuilder.getInstance(context)

    init {

        getAllEmpObserver()
    }


   private fun getAllEmpObserver(){
     viewModelScope.launch {
         val emp = roomDatabase.empDao().getAllEmp()
         allEmp = emp
     }

   }



    fun addEmployee(empEntity: EmpEntity){
       Executors.newSingleThreadExecutor().execute {
           roomDatabase.empDao().insertEmp(
                   EmpEntity(
                          empEntity.id,
                           empEntity.name,
                           empEntity.address,
                           empEntity.phone

                   )
           )
       }
    }


//    fun InsertemployeeData(empEntity: EmpEntity){
//        var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()
//        dao!!.insertEmp(empEntity)
//        getAllEmployee()
//    }
//
//    fun UpdateEmployee(empEntity: EmpEntity){
//        var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()
//
//        dao!!.updateEmp(empEntity)
//        getAllEmployee()
//    }
//
//    fun DeleteEmployee(empEntity: EmpEntity){
//       var dao= RoomAppDb.getAppDatabase((getApplication()))?.empDao()
//
//        //var dao = repo.insert(empEntity)
//        dao!!.deleteEmp(empEntity)
//        getAllEmployee()
//    }
//
//    fun addData(){
//
//    }
}