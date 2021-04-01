package com.example.tictactoe.mvp.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityMVVMMainBinding
import com.example.tictactoe.mvp.mvp.Model.model.player

class MVVM_MainActivity : AppCompatActivity(){
    var buttons = arrayOfNulls<Button>(9)
    var activityGameBinding: ActivityMVVMMainBinding? = null
    var row:Int?=0
    var col:Int?=0


    lateinit var gameViewModel: TicTacToeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        winnerPlayerLabelmvvm = findViewById(R.id.winnerPlayerLabelmvvm)
//        winnerPlayerViewGroupmvvm= findViewById(R.id.winnerPlayerViewGroupmvvm)

         activityGameBinding= DataBindingUtil.setContentView(this, R.layout.activity_m_v_v_m__main)
        gameViewModel = ViewModelProviders.of(this).get(TicTacToeViewModel::class.java)
        activityGameBinding?.gameViewModel = gameViewModel



        gameViewModel.getWinner()?.observe(this, Observer {
            winner:player?->onGameWinnerChanged(winner!!)
           Log.i("mvvm winner", "winner is : ")
        })

    }


    fun onGameWinnerChanged(winner: player) {
        if (winner == null)
           activityGameBinding?.winnerPlayerLabelmvvm?.text = "its a tie"
        else
            activityGameBinding?.winnerPlayerLabelmvvm?.text = winner.toString()

    }


}

