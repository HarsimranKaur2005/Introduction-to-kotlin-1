package com.example.intro_to_kotlin1

import kotlin.math.log

class question1 {

//Write a program to replace a substring inside a string with another string.


    fun q1(){
        var str:String = "This is Question 1 - Welcome students"
        val oldstr:String = "students"
        val newstr:String = "Newers"

        val output = str.replace(oldstr, newstr)

       println(output)
    }
}