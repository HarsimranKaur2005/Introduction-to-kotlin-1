package com.example.mockito

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Myviewmodel:ViewModel() {

    private  var ischecked:MutableLiveData<Boolean>
    var repo = myRepository()

    init {

        ischecked = MutableLiveData()
    }

    fun check(ischecked: Boolean): Boolean {
        var check = repo.check(ischecked)
        if (check == true)
            return false
        else
            return true
    }

   fun getData():MutableLiveData<Boolean> {
       Log.i("checkValue", "viewmodel: "+ (repo.checked).toString())
        return repo.checked
    }
}