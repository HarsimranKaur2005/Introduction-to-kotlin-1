package com.example.tictactoe.mvp.mvp.Model.model

class cell {
    private var value: player?=null

    fun getPlayerValue(): player {return value!!}
    fun setPlayerValue(value: player){this.value=value}
}

//data class cell(var value: player)