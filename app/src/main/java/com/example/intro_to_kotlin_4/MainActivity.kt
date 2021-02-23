package com.example.intro_to_kotlin_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //WAP using Lambda function to calculate the Simple Interest.
        println("****** QUESTION 1*******")
        var q1 = question1()
        q1.main()

        //Create a list of Employee which will have name and age as properties. print the name of all employees age >30.
        println("****** QUESTION 2 ******")
        var q2=question2()
        q2.ques2()
    }
}