package com.example.tictactoe.Model

import android.util.Log

class Board {


private val cells = Array(3){Array(3){" "} }
    var winner:player?= null
    lateinit var currentTurn: player
    lateinit var gameState:GameState



    fun restart(){
        clearCells()
        winner= null
        currentTurn = player.X
        gameState = GameState.IN_PROGRESS
    }


    /**
     *  To clear all cells
     */
    private fun clearCells() {
        for (i in 0..2){
            for(j in 0..2){
                cells[i][j]= ""
            }
        }
    }




    fun mark(row: Int, col: Int): player? {

        var playerThatMoved:player? = null
        if (isValid(row,col)){
            cells[row][col]= currentTurn.toString()
            Log.i("current", "$currentTurn ****")
            playerThatMoved=currentTurn
            
            if (isWinningMoveByPlayer(currentTurn, row, col))
            {

                winner=currentTurn
                gameState = GameState.FINISHED
            }
            else{

                flipTurn()
            }
        }

        if(gameState == GameState.FINISHED)
        {return null}
else
        return playerThatMoved!!
    }


     fun getGameWinner():player{
        return winner!!
    }
    /**
     * function to flip the turn
     */

    private fun flipTurn() {
        if (currentTurn == player.X)
        { currentTurn = player.O}
        else
        {currentTurn = player.X}
    }

    /**
     * return true is any of these condition matches
     * conditions that are required to win the game
     */
    private fun isWinningMoveByPlayer(player: player, currentRow: Int, currentCol: Int): Boolean {

        return ((
        // 3 -in-a row
                cells[currentRow][0] == player.toString()
                && cells[currentRow][1]== player.toString()
                && cells[currentRow][2]== player.toString())

                // or 3-in-a column
                ||(cells[0][currentCol]== player.toString()
                && cells[1][currentCol]== player.toString()
                && cells[2][currentCol]== player.toString())

                // diagnol
                ||(currentCol==currentRow
                && cells[0][0]== player.toString()
                && cells[1][1]== player.toString()
                && cells[2][2]== player.toString())

                //opposite diagnal
                ||(currentCol+currentRow ==2
                && cells[0][2]== player.toString()
                && cells[1][1]== player.toString()
                && cells[2][0]== player.toString())

                )
    }

    /**
     * check if the cell selected is valid or not
     * @return boolean
     */
    fun isValid(row: Int, col: Int):Boolean{
        if (gameState == GameState.FINISHED)
        {return false}
        else
            if( isOutOfBound(row) || isOutOfBound(col))
            {return false}
            else if (isCellValueAlreadySet(row,col))
            {return false}
            else
            {return true}
        }



    /**
     * check that whether the  cell is already set
     */
    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return !(cells[row][col].isEmpty())
    }


    /**
     * check that given row or col is in range
     * @return boolean value
     */
    private fun isOutOfBound(row: Int): Boolean {
        return (row<0 || row>2)
    }

}