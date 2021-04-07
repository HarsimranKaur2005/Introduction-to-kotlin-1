package com.example.mockito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var model: Myviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       model= ViewModelProviders.of(this).get(Myviewmodel::class.java)
//       /
        model.getData().observe(this, Observer {
                data:Boolean?-> ischeckbox(data)
        })
    }

    private fun ischeck() {



    }

    private fun ischeckbox(data: Boolean?) {
        if (data!!)
            checkbox.isChecked = false
        else
            checkbox.isChecked = true

    }
}