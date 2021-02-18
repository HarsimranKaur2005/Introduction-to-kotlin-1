package com.example.intro_to_kotlin_2

//Write a program to print your Firstname,LastName & age using init block,companion object.


class question1(fname:String, lname:String, age:Int) {
    init {
        println("---INIT BLOCK---")
        println("Firstname: " + fname);
        println("Lastname: "+ lname)
        println("Age: "+ age)

    }
}

class companionClass{
    companion object{

        const val fname="Harsimran"
        const val lname="Kaur"
        const val age=23
    }

}
