package com.example.mockito

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class Myviewmodel(application: Application):AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val myRepo:MyRepository = MyRepository(context)
      var isItemchecked:MutableLiveData<Boolean> = myRepo.getCheckedItem()
    private val TAG = Myviewmodel::class.java.simpleName


    fun UncheckItem(){
        myRepo.UncheckItem()
        isItemchecked.value=myRepo.getCheckedItem().value

    }

    fun CheckItem(favItem:MyDataclass){
        myRepo.saveitem(favItem)
        isItemchecked.value=myRepo.getCheckedItem().value
    }

}