package com.example.tictactoe.MVP.View

interface TicTacToeView {
    fun setButtonText(row:Int, col:Int, text:String)
    fun showWinner(winningPlayer: String) {

    }
}