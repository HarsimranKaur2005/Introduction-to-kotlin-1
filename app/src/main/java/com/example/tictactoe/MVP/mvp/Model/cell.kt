package com.example.tictactoe.MVP.mvp.Model

class cell {
    private var value:player?=null

    fun getPlayerValue():player{return value!!}
    fun setPlayerValue(value: player){this.value=value}
}

//data class cell(var value: player)