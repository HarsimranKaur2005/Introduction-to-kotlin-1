package com.example.intro_to_kotlin_4


//Create a list of Employee which will have name and age as properties. print the name of all employees age >30.
data class employee(var name:String, var age:Int)

class question2 {
    fun ques2(){
        var emp = listOf<employee>(employee("harsimran", 23),
            employee("simmy   ", 27),
            employee("simarpreet  ", 32),
            employee("karandeep", 35),
            employee("shubham", 31)

        )

        var result = emp.filter { employee -> employee.age>30 }
        println(result)
    }
}