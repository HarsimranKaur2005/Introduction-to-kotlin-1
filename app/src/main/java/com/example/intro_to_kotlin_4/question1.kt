package com.example.intro_to_kotlin_4

//WAP using Lambda function to calculate the Simple Interest.
class question1 {

    fun main(){
      var result:(Int)->(Unit) = {s:Int-> println("simple interest is: "+ s) }
        simpleInterest(5000,2,5,result)
    }

    fun simpleInterest(p:Int, r:Int, t:Int, result: (Int)->Unit)
    {
        var output = (p*r*t)/100
        result(output)
    }
}