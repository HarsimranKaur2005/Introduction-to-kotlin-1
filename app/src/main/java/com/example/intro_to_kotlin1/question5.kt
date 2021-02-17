package com.example.intro_to_kotlin1

class question5 {

    //Find common elements between two arrays.

    fun q5(){

       // print("***this is question 5***")
        println()
        var array1 = arrayOf(1,2,3,4,5,6)
        var array2 = arrayOf(2,4,7,9,0,3,6)

      var set1 = mutableSetOf<Int>()
      var set2 = mutableSetOf<Int>()

        for( i in array1)
        {set1.add(i)}

        for(i in array2)
        { set2.add(i)}

        set1.retainAll(set2);
        println("common elements are: "+ set1)

    }
}