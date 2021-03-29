package com.example.tictactoe.mvp.MVVM

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.mvp.MVVM.StringUtility.stringFromNumbers
import com.example.tictactoe.mvp.mvp.Model.model.Board
import com.example.tictactoe.mvp.mvp.Model.model.player


class TicTacToeViewModel : ViewModel(){

    var board = Board()

    lateinit var cells: ObservableArrayMap<String,String>

    init {
        board.restart()
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row:Int, col:Int){
        var playerThatMoved = board.mark(row, col)

        if (playerThatMoved !=null){
            cells.put(stringFromNumbers(row,col), playerThatMoved.toString())

           // view.setButtonText(row, col, playerThatMoved.toString())

//            if (board.getGameWinner()!=null)
//            {
////                cells.put(stringFromNumbers(row,col), playerThatMoved.toString())
////                view.showWinner(playerThatMoved.toString())
//            }

        }
//        else
//            view.showWinner("Its a Draw match")
    }

    fun getWinner():LiveData<player>{
        return board.mvvmWinner
    }
    }

