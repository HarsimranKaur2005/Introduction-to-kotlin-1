package com.example.intro_to_kotlin_2

//Write a single program for following operation using overloading
//  A) Adding 2 integer number
//  B) Adding 2 double
//  D) multiplying 2 int
//  E) concate 2 string
//  F) Concate 3 String

class question2 {

    fun operation(a:Int,b:Int ):Int{
        return a+b
    }

    fun operation(a:Double,b:Double):Double{
        return  a+b
    }

   fun multiply(a:Int,b:Int):Int{
        return a*b
    }
    fun operation(a:String,b:String):String{
        return a.plus(" ").plus(b)
    }

    fun operation(a:String,b: String,c:String):String{
        return a.plus(" ").plus(b).plus(" ").plus(c)
    }


}