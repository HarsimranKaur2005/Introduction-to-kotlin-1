package com.example.intro_to_kotlin_2

//Write a function which take marks as an argument and return the the grade as follows:
//marks between 50 to 60 , return “Good”
//marks between 60 to 70, return “Very Good”
//marks between 70 to  80, return “Excellent”
//marks between  80 to 100, return “Rockstar”


class question5 {

    fun marks(x: Int) {
        var result = when (x) {
            in 50..60 ->  "Good"
            in 61..70 ->"Very Good"
            in 71..80 -> "Excellent"
            in 81..100 -> "Rockstar"
            else -> "Invalid"
        }

        println(result)
    }
}