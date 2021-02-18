package com.example.intro_to_kotlin_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Write a program to print your Firstname,LastName & age using init block,companion object.
        println("****** QUESTION 1 ******")
        var ques1 = question1("Harsimran","kaur", 23)

        println("---COMPANION BLOCK---")
        println("Firstname: " + companionClass.fname);
        println("Lastname: " + companionClass.lname);
        println("age: " + companionClass.age);

    //Write a single program for following operation using overloading
    //  A) Adding 2 integer number
    //  B) Adding 2 double
    //  D) multiplying 2 int
    //  E) concate 2 string
    //  F) Concate 3 String

        println("****** QUESTION 2 ******")
        var ques2 = question2()

        println("A. adding 2 int: " + ques2.operation(4,8));
        println("B. adding 2 double: "+ ques2.operation(1.8e5, 10.0))
        println("C. Multiply 2 int: " + ques2.multiply(5,2))
        println("D. concatenation of 2 strings: "+ ques2.operation("hello", "there"))
        println("E. concatenation of 3 strings: "+ ques2.operation("Good", "Morning", "!!!"))

//Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific details like rateofinterest etc,print details of every bank.

        println("****** QUESTION 3 ******")
        var bank = bank()
        bank.get_details()

        var sbi= sbi()
        sbi.get_details()

        var icici=icici()
        icici.get_details()


        //Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts in your design.Also try to use interfaces and abstract classes.

        println("****** QUESTION 4 ******")
        var ques4=question4()
        ques4.add(1,"maths","RD sharma")
        ques4.add(2,"science", "NCERT")
        ques4.add(3,"2 states", "chetan bhagat")
        ques4.totalbook()

        ques4.removeBook()
        ques4.totalbook()



//        Write a function which take marks as an argument and return the the grade as follows:
//        marks between 50 to 60 , return “Good”
//        marks between 60 to 70, return “Very Good”
//        marks between 70 to  80, return “Excellent”
//        marks between  80 to 100, return “Rockstar”

        println("****** QUESTION 5 ******")
        var ques5=question5()
        ques5.marks(70)

///Write a program to create mutable list of Integer. replace the second item in the list with new value. Print the list value.
        println("****** QUESTION 6 ******")
        var ques6=question6();
        print("original list: ")
        ques6.printMyList()

        ques6.replace()

        //Write a program to create mutable map. print all the value and key of map.
        println("****** QUESTION7 ******")
        var ques7=question7()
        ques7.funMap()


        //Write a program to create HasSet. print all the value.
        println("****** QUESTION 8 ******")
        var ques8 = question8()
        ques8.printSet()
    }
}