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
            isEmailValid(email)
        }

    }

    /**
     * Requirements to check:-
     * 1) Email should contain @ and .
     * 2)Email must not be blank
     * 3)Email must not contain hyphen(-)
     * 4)Email must not start with underscore(_) or @
     */
     fun isEmailValid(email: String):Boolean {
         if(email.contains(" "))
            return false
         else if (!(email.contains("@") && email.contains(".")))
            return false

         else if(email.contains("-"))
         return false
         else if(email.startsWith("@") || email.startsWith("_"))
            return false

         return true
    }



//    fun EmailStartWith(email: String): Boolean {
//         return !email.startsWith("@")
//    }
//
//    fun EmailContainDot(email: String): Boolean {
//        return email.contains(".")
//
//    }
//
//    fun EmailIsEmpty(email:String):Boolean {
//        return email != null
//    }
//    fun EmailIsValid(email: String):Boolean{
//        return !(!email.contains("@") && !(email.contains(".")))
//    }


}