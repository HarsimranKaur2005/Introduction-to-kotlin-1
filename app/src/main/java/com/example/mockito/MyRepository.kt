package com.example.mockito

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData

open class MyRepository(context: Context) {
    private val myModel:myModel = myModel(context)

    fun getCheckedItem() = myModel.getCheckedItems()

    fun UncheckItem()= myModel.uncheckItem()

    fun saveitem(favItem:MyDataclass) = myModel.saveItems(favItem)



}