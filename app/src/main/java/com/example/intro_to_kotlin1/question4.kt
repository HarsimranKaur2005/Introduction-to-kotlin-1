package com.example.intro_to_kotlin1

class question4 {

    //Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String

    fun q4(){
       // print("***This is question 4***")
        println()
        var str = "Hell0 Every0ne, I am HarSimran K@ur"
        var upperCount:Int = 0
        var lowerCount:Int =0
        var digitCount:Int =0
        var otherCount:Int=0
        var len = str.length

        for(i in 0..len-1){
            var ch = str.get(i)

            if(ch.isUpperCase())
            {upperCount++}

            else if(ch.isLowerCase())
            {lowerCount++}

            else if(ch.isDigit())
            {digitCount++}

            else
            {otherCount++
           }
        }// for i loop closed

        var ucPercentage = (upperCount * 100)/len
        var lcPercentage = (lowerCount * 100)/len
        var digitPercentage = (digitCount * 100)/len
        var otherPercentage = (otherCount * 100)/len

        println("# of lowercase: "+ lowerCount+" and percentage is: " + lcPercentage)
        println("# of uppercase: "+ upperCount+" and percentage is: " + ucPercentage)
        println("# of Digit: "+ digitCount +" and percentage is: " + digitPercentage)
        println("# of Other: "+ otherCount+" and percentage is: " + otherPercentage)


    }
}