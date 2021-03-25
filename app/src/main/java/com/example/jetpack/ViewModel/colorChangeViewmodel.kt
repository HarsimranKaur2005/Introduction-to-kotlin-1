package com.example.jetpack.ViewModel

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class colorChangeViewModel : ViewModel() {

    var selectColor:List<Int> = listOf(
        Color.BLACK,
        Color.BLUE,
        Color.GREEN,
        Color.CYAN,
        Color.GRAY,
        Color.MAGENTA,
        Color.RED,
        Color.YELLOW,
        Color.WHITE
    )

    init {
        Collections.shuffle(selectColor)
        Log.i("ColorChange", "ColorChange created!!")
    }


    fun changeColor():Int?{


        var random = Random()
        return selectColor.get(random.nextInt(selectColor.size))

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ColorChange", "ColorChange destroyed")
    }
}