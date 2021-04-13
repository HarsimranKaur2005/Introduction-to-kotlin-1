package com.example.mockito

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class myModel(private val context: Context) {

    private val FAVORITE_KEY = "isFavorite"

    private val preference:SharedPreferences = context.getSharedPreferences("fav", Context.MODE_PRIVATE)
    private val editor:SharedPreferences.Editor = preference.edit()

    fun getCheckedItems(): MutableLiveData<Boolean> {
        return MutableLiveData(preference.getBoolean(FAVORITE_KEY, false))

    }

    fun uncheckItem(){
        editor.remove(FAVORITE_KEY)
        editor.commit()
        Toast.makeText(context, "Item removed from favorite", Toast.LENGTH_SHORT).show()

    }

    fun saveItems(favItem: MyDataclass) {
        editor.putBoolean(FAVORITE_KEY, favItem.checkbox)
        editor.commit()
        Toast.makeText(context, "Item added to favourite", Toast.LENGTH_SHORT).show()


    }


}