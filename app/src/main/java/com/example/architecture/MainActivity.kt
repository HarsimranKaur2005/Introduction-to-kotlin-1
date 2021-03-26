package com.example.architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.Presenter.TicTacToePresenter

class MainActivity : AppCompatActivity() {



    //object of presenter class
    val presenter = TicTacToePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}