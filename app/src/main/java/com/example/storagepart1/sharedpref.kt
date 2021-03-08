package com.example.storagepart1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class sharedpref : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpref)

        val et_text = findViewById<EditText>(R.id.et_text)
        val pref = this.getPreferences(Context.MODE_PRIVATE)
        val submit = findViewById<Button>(R.id.submit_btn)
        val retrive = findViewById<Button>(R.id.retrieve_btn)
        val textview = findViewById<TextView>(R.id.textview)
        submit.setOnClickListener(){

            //store value in sharedPreferences

            val editor = pref.edit()

            val text:String? = et_text.text.toString()

            if (text.isNullOrBlank()){
                Toast.makeText(this,"Please enter text", Toast.LENGTH_SHORT).show()
            }

            else{
                //clear the text after saving it to variable
                et_text.text!!.clear()

                //Putting Values
                editor.putString("DemoText", text)
                editor.apply()
                Toast.makeText(this,"Click on retrieve button",Toast.LENGTH_SHORT).show()
            }
        }



        retrive.setOnClickListener(){
            val retrieve_data = pref.getString("DemoText","")
            if (retrieve_data.isNullOrBlank())
            {
                Toast.makeText(this,"Enter text first", Toast.LENGTH_SHORT).show()

            }
            else
            {
                et_text.setText(retrieve_data)
            }
        }
    }
}