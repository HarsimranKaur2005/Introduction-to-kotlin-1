package com.example.intro_to_kotlin_3

//WAP to create extension function.

class question4 {

    fun String.removeChar():String = this.substring(1,this.length-1)


    fun print(){
        val str = "Harsimran Kaur"
        var result= str.removeChar()
        println("New text is : ${result}")
    }

}