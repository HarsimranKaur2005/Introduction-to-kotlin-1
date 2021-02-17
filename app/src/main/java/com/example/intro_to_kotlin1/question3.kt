package com.example.intro_to_kotlin1

class question3 {

    // Write a program to find the number of occurrences of a character in a string without using loop.

    fun q3(str: String,ch:Char ): Int {

        if(str.length == 0)
            return 0;
        else if (str.get(0) == ch)
            return 1 + q3(str.substring(1),ch)
        else
            return q3(str.substring(1),ch)



    }
}