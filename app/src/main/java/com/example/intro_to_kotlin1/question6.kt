package com.example.intro_to_kotlin1

class question6 {

    //Check letter in string which do not have pair.

    fun q6(){
//println("***this is question 6***")
        var str = "aabccdee"

        var i=0
        while (i<str.length-1)
        {
            if(str[i]!=str[i+1])
            {
                println(str[i] + " ")
                i++;
            }
            else
                i+=2
        }

    }
}