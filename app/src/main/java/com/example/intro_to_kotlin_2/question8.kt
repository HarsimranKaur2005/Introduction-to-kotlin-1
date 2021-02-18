package com.example.intro_to_kotlin_2

//Write a program to create HasSet. print all the value.

class question8 {
    val myHashset = hashSetOf<String>("Morning","evening","afternoon", "night")

    fun printSet(){
        println("Values in the Hash Set are: $myHashset")
    }
}