package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var email:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = et_email.text.toString()

        btnValidate.setOnClickListener(){
            isValidate(email)
        }

    }

     fun isValidate(email: String):Boolean {
        if (EmailIsValid(email))
            return false
        else if(EmailIsEmpty(email))
            return false
         else if(!EmailContainDot(email))
         return false
         else if(EmailStartWith(email))
            return false
         else 
            return true
    }



    fun EmailStartWith(email: String): Boolean {
         return !email.startsWith("@")
    }

    fun EmailContainDot(email: String): Boolean {
        return email.contains(".")

    }

    fun EmailIsEmpty(email:String):Boolean {
        return email != null
    }
    fun EmailIsValid(email: String):Boolean{
        return !(!email.contains("@") && !(email.contains(".")))
    }


}