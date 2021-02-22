package com.example.intro_to_kotlin_3

//WAP to create singleton class.

object question2 {
    init {
        println("Singleton class invoked")
    }
    var name = " harsimran kaur"
    fun showname(){
        println(name)
    }
}


class A{
    init {
        println("this is another class with new name: ${question2.name}")
        question2.showname()
    }
}