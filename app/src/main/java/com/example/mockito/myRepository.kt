package com.example.mockito

import android.util.Log
import androidx.lifecycle.MutableLiveData

class myRepository {
     var checked: MutableLiveData<Boolean> = MutableLiveData()
    fun getresult(){}


    fun check(ischecked: Boolean):Boolean {
        if (ischecked==true) {
            checked.value = true
            Log.i("checkValue", "****** ${checked.value}")
            return true

        }
        else
        { checked.value=false
        return false}
    }
}