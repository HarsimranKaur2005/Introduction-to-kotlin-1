package com.example.tictactoe.mvp.mvp.Model.View

interface TicTacToeView {
    fun setButtonText(row:Int, col:Int, text:String)
    fun showWinner(winningPlayer: String) {

    }
}