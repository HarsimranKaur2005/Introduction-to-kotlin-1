package com.example.storagepart1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class FileHandling : AppCompatActivity() {
lateinit var edittext:EditText
    companion object{
        const val NAME = "DemoFile"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_handling)


        edittext = findViewById(R.id.et_file)
        val write=findViewById<Button>(R.id.write_btn)
        write.setOnClickListener(){
            writeFile()
        }

        val read = findViewById<Button>(R.id.read_btn)
        read.setOnClickListener(){
            readFromFile()
        }
    }

    private fun readFromFile() {
        val fin = openFileInput(NAME)
        var c:Int
        var str=""
        while(fin.read().also { c=it }!= -1){
            str+= c.toChar().toString()
        }

        if (str.isEmpty()){
            Toast.makeText(applicationContext,"Enter text first", Toast.LENGTH_SHORT).show()

        }
        else{
            edittext.setText(str)
        }
        fin.close()
    }

    private fun writeFile() {
       try {
           val fout = openFileOutput(NAME, Context.MODE_PRIVATE)


           val str: String? = edittext.text.toString()

           if (str.isNullOrBlank()) {
               Toast.makeText(applicationContext, "Enter text first", Toast.LENGTH_SHORT).show()

           } else {
               edittext.text!!.clear()
               fout.write(str.toByteArray())

           }
       } catch (e:Exception){e.printStackTrace()}

    }
}