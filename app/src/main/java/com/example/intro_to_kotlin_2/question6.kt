package com.example.intro_to_kotlin_2

//Write a program to create mutable list of Integer. replace the second item in the list with new value. Print the list value.

public class question6
{
    val list = mutableListOf<Int>(1,4,6,7)
    //printMyList()

    fun replace(){
        list[1]=10
        println("list after replacing: ")
        printMyList()
}
     fun printMyList(){
        println(" $list")
    }

}