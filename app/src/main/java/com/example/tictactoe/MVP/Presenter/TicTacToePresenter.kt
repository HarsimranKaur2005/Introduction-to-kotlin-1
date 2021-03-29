package com.example.tictactoe.MVP.Presenter

import com.example.tictactoe.MVP.mvp.Model.Board
import com.example.tictactoe.MVP.View.TicTacToeView

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