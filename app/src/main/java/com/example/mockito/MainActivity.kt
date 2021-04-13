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

        val application = this.application
       model= ViewModelProviders.of(this).get(Myviewmodel(application)::class.java)
//       /
        model.isItemchecked.observe(this, Observer {
            checkboxch.isChecked = it
        })

        setUIListeners()

}

    private fun setUIListeners() {
        buttonme.setOnClickListener()
        {
            if (checkboxch.isChecked){
              model.UncheckItem()
            }
            else{

                model.CheckItem(MyDataclass(textView.text.toString(), true))

            }
        }
    }
    }
