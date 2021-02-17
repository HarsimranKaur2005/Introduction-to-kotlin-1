package com.example.intro_to_kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a program to replace a substring inside a string with another string.
        println("***This is Question 1***")
        var ques1 = question1();
        ques1.q1();

        //Write a program to find the number of occurrences of the duplicate words in a string and print them.
        println("***This is Question 2***")
        var ques2 = question2();
        ques2.q2();


       // Write a program to find the number of occurrences of a character in a string without using loop.
        println("***This is Question 3***")
        var ques3=question3();
        println("the number of occurencce is: " + ques3.q3("hello there!", 'e'))

        //Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
        println("***This is Question 4***")
        var ques4 = question4();
        ques4.q4();

        //Find common elements between two arrays.
        println("***This is Question 5***")
        var ques5 = question5();
        ques5.q5();

        //Check letter in string which do not have pair.
        println("***This is Question 6***")
        var ques6 = question6();
        ques6.q6();


    }
}