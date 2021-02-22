package com.example.intro_to_kotlin_3

//WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have base class object as an argument and it will return name of the subclass based argument type.

sealed class question3 {
//    val text = "This is base class text"

    fun getClassName(q3:question3){
        println(" calling from object of ${q3.javaClass}")}

}

class subClass1: question3(){ }
class subClass2: question3(){ }
class subClass3: question3(){ }


