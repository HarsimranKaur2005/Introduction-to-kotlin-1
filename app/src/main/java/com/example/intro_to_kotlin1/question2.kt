package com.example.intro_to_kotlin1

class question2 {
    //Write a program to find the number of occurrences of the duplicate words in a string and print them.

    fun q2(){
        //println("**This is Question 2**")
        var str="one two three four five one three five six"
        str = str.toLowerCase();
        var words = str.split(" ").toTypedArray();
        var len = words.size;

        for (i in 0..len){
            var count =1;

            for( j in i+1..len-1){
                if(words[i].equals(words[j]))
                { count++;
                words[j]="0"
                }
            } // j loop closed
            if(count > 1 && words[i]!= "0")
             println(words[i])
        } // i loop closed

    }
}

