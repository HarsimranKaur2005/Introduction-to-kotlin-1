package com.example.tictactoe.mvp.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tictactoe.mvp.mvp.Model.model.GameState
import com.example.tictactoe.mvp.mvp.Model.model.player

class Boardmvvm {

    private val cells = Array(3){Array(3){" "} }
    var winner: player?= null
    var mvvmWinner: MutableLiveData<player> = MutableLiveData()
    lateinit var currentTurn: player
    lateinit var gameState: GameState



    fun restart(){
        clearCells()
        winner= null
//        mvvmWinner.value=null
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


/*
function will check if the cell is valid or not and if it is valid
it will return the player to presenter and that will set at the cell
and it will also check for winner
 */

    fun mark(row: Int, col: Int): player? {

        var playerThatMoved: player? = null
        if (isValid(row,col)){
            cells[row][col]= currentTurn.toString()

            playerThatMoved=currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, col))
            {

                mvvmWinner.value= currentTurn

                  Log.i("current", "${mvvmWinner.value} ****")
                gameState = GameState.FINISHED

            }
            else{

                flipTurn()
            }
        }
        return if (gameState == GameState.FINISHED){
            mvvmWinner.value
        }
        else
            playerThatMoved

    }

    fun getMVVMWinner(): player?{
        return mvvmWinner.value
    }



    /**
     * function to flip the turn
     */

    private fun flipTurn() {
        if (currentTurn == player.X)
        { currentTurn = player.O
        }
        else
        {currentTurn = player.X
        }
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
        return if (gameState == GameState.FINISHED)
        { false}

        else
            if( isOutOfBound(row) || isOutOfBound(col))
            {false}
            else !(isCellValueAlreadySet(row,col))

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