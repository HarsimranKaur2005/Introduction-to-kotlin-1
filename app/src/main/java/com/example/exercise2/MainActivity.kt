package com.example.exercise2


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    val MIN_PASSWORD_LENGTH = 6;
  lateinit var etUsername :EditText
    lateinit var etEmail :EditText
    lateinit var etPassword :EditText
    lateinit var etPhone :EditText
    lateinit var signupbtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         etUsername = findViewById<EditText>(R.id.et_username)
         etEmail = findViewById<EditText>(R.id.et_email)
         etPassword = findViewById<EditText>(R.id.et_pwd)
         etPhone = findViewById<EditText>(R.id.et_phNo)
         signupbtn = findViewById<Button>(R.id.btn_signup)



        signupbtn.setOnClickListener{

            val uname:String? = etUsername.text.toString()
            val email:String? = etEmail.text.toString()
            val pwd:String?= etPassword.text.toString()
            val phone:String?= etPhone.text.toString()


            if(validate()){
                var intent = Intent(this, homePage::class.java)
                var bundle = Bundle()
                bundle.putString("username", uname)
                bundle.putString("email", email)
                bundle.putString("number", phone)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else
            {finish()}

        }
    }

    fun validate():Boolean{

        if(etUsername.text.toString().isNullOrEmpty())
        {Toast.makeText(applicationContext, "Please enter Username",Toast.LENGTH_SHORT).show()
        return false}

        if(etEmail.text.toString().isNullOrEmpty() or (!etEmail.text.toString().contains("@")))
        {Toast.makeText(applicationContext, "Please enter valid email",Toast.LENGTH_SHORT).show()
        return false}

        if(etPassword.text.toString().isNullOrEmpty() or(etPassword.text.toString().length <MIN_PASSWORD_LENGTH))
        {Toast.makeText(applicationContext, "Please enter Password",Toast.LENGTH_SHORT).show()
        return false}

        if(etPhone.text.toString().isNullOrEmpty())
        {Toast.makeText(applicationContext, "Please enter phone number",Toast.LENGTH_SHORT).show()
        return false}

        return true
    }


    override fun onStart() {
        super.onStart()
        Log.e("LIFE_CYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LIFE_CYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LIFE_CYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LIFE_CYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LIFE_CYCLE", "onDestroy")
    }
}