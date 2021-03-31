package com.example.tictactoe.mvp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R
import com.example.tictactoe.mvp.mvvm.MVVM_MainActivity
import com.example.tictactoe.mvp.mvp.Model.View.MainActivity
import kotlinx.android.synthetic.main.activity_launcher.*

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        mvpbtn.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        mvvmbtn.setOnClickListener(){
            var intent = Intent(this, MVVM_MainActivity::class.java)
            startActivity(intent)
        }
    }
}