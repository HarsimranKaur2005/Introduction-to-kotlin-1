package com.example.tictactoe.mvp.MVVM

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityMVVMMainBinding
import com.example.tictactoe.mvp.mvp.Model.model.player
import kotlinx.android.synthetic.main.activity_m_v_v_m__main.*

class MVVM_MainActivity : AppCompatActivity(), View.OnClickListener {
    var buttons = arrayOfNulls<Button>(9)
//    lateinit var winnerPlayerLabelmvvm: TextView
//    lateinit var winnerPlayerViewGroupmvvm:View
    lateinit var gameViewModel: TicTacToeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        winnerPlayerLabelmvvm = findViewById(R.id.winnerPlayerLabelmvvm)
//        winnerPlayerViewGroupmvvm= findViewById(R.id.winnerPlayerViewGroupmvvm)
        initDataBinding()
    }

    private fun initDataBinding() {

        var activityGameBinding : ActivityMVVMMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_m_v_v_m__main)
        gameViewModel = ViewModelProviders.of(this).get(TicTacToeViewModel::class.java)
        activityGameBinding.gameViewModel=gameViewModel




        //setUpOnGameEndListener()

        for(i in 0..buttons.size-1)
        {
            var buttonnID = "btn_"+i
            var resourceId = resources.getIdentifier(buttonnID, "id", packageName)
            buttons[i] = findViewById(resourceId)
            buttons[i]!!.setOnClickListener(this)
        }


    }

    private fun setUpOnGameEndListener() {

        }




    private fun onGameWinnerChanged(winner: player) {
        if(winner==null )
            winnerPlayerLabelmvvm.setText("no winner")
        else
            winnerPlayerLabelmvvm.setText(winner.toString())

    }

    override fun onClick(v: View?) {
        gameViewModel.getWinner().observe(this, Observer {
                winner:player? -> this.onGameWinnerChanged(winner!!) })
    }


}