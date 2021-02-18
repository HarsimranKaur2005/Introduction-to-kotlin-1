package com.example.intro_to_kotlin_2

//Write a program to create mutable map. print all the value and key of map.

class question7 {
    fun funMap(){
        val mymap = mutableMapOf<Int,String>(Pair(1,"shinchan"), Pair(2, "Doremon"), Pair(3, "Bheem"))
        for (i in mymap)
        {
            println("Key:${i.key}, Value: ${i.value}")
        }
    }
}