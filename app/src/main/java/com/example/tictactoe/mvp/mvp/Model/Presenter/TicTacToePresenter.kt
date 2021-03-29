package com.example.tictactoe.mvp.mvp.Model.Presenter

import com.example.tictactoe.mvp.mvp.Model.View.TicTacToeView
import com.example.tictactoe.mvp.mvp.Model.model.Board

class TicTacToePresenter():Presenter {

    lateinit var view: TicTacToeView
    constructor(view:TicTacToeView):this(){
        this.view = view
    }
     var model: Board = Board()


    override fun onCreate() {
    model.restart()
    }

    //mark the area
    fun onButtonSelected(row: Int, col: Int) {
    var playerThatMoved = model.mark(row, col)

        if (playerThatMoved !=null){
            view.setButtonText(row, col, playerThatMoved.toString())

            if (model.getGameWinner()!=null)
            {
                view.showWinner(playerThatMoved.toString())
            }

        }
        else
            view.showWinner("Its a Draw match")
    }
}