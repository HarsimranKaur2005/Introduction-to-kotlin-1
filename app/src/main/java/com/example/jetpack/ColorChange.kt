package com.example.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.ViewModel.colorChangeViewModel

class ColorChange : AppCompatActivity() {
    lateinit var  viewModel: colorChangeViewModel
    lateinit var frame: FrameLayout
    private var color:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_change)


            var btn = findViewById<Button>(R.id.btnclickme)
            frame = findViewById<FrameLayout>(R.id.colorchangelayout)

            //initialize view model
            viewModel= ViewModelProvider(this).get(colorChangeViewModel::class.java)

            btn.setOnClickListener(){

                //call changeColor func from view model that will return random color from the list
                color = viewModel.changeColor()
                frame.setBackgroundColor(color!!)
            }



        }

//    override fun onResume() {
//        super.onResume()
//        frame.setBackgroundColor(viewModel.changeColor()!!)
//
//    }


        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            color = savedInstanceState.getInt("color")
            frame.setBackgroundColor(color!!)
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putInt("color", color!!)

        }
    }
