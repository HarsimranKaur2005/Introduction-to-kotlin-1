package com.example.intro_to_kotlin_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import java.util.zip.ZipEntry

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("****** QUESTION 1 *******")
        //class not found exception
        try {
            Class.forName("question1")
        }
        catch (e: Exception)
        {e.printStackTrace()}




        //WAP to create singleton class.
        println("****** QUESTION 2 ******")
        question2.showname()
        question2.name="2005simmy"
        var q2 = A()

        //WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have base class object as an argument and it will return name of the subclass based argument type.
        println("****** QUESTION 3 ******")
        var a = subClass1()
        var b = subClass2()
        var c = subClass3()

        a.getClassName(a)
        a.getClassName(b)
        a.getClassName(c)

       // WAP to create extension function.
        println("****** QUESTION 4 ******")
        var q4=question4()
        q4.print()


    }
}