package com.example.tictactoe.mvp.mvvm

import android.util.Log
import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.mvp.mvp.Model.model.player
import com.example.tictactoe.mvp.mvvm.StringUtility.stringFromNumbers


class TicTacToeViewModel : ViewModel(){

    var board = Boardmvvm()
    var cells: ObservableArrayMap<String,String>


    init {
        board.restart()
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row:Int, col:Int) {
        var playerThatMoved = board.mark(row, col)

        if (playerThatMoved != null) {

            cells[stringFromNumbers(row, col)] = playerThatMoved.toString()

            if (board.getMVVMWinner() != null)
            {

               MVVM_MainActivity().onGameWinnerChanged(board.getMVVMWinner()!!)

            }


        }
    }

    fun getWinner(): MutableLiveData<player> {
        Log.i("current", "simmy ****")
        return board.mvvmWinner
    }



    }

