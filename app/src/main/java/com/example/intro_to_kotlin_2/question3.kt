package com.example.intro_to_kotlin_2

//Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific details like rateofinterest etc,print details of every bank.



open class bank(){
    var bname:String=""
    var location:String=""


    open fun get_details(){
        bname = "bank"
        location = "India"
        println("This is the parent class:BANK ")
        println("details are:- name: "+bname+" and location: "+ location+ " and rate of interest is: " + 2)
    }

}

class sbi : bank(){
    override fun get_details() {
        bname = "SBI"
        location = "Noida"
        println("This is child class 1")
        println("details are:- name: "+bname+" and location: "+ location+ " and rate of interest is: " + 5.7)

    }
}

class boi : bank() {
    override fun get_details() {
        bname = "BOI"
        location = "Gurugram"
        println("This is child class 2")
        println("details are:- name: " + bname + " and location: " + location + " and rate of interest is: " + 3.5)


    }
}

class icici : bank() {
    override fun get_details() {
        bname = "ICICI"
        location = "New Delhi"
        println("This is child class 3")
        println("details are:- name: " + bname + " and location: " + location + " and rate of interest is: " + 6.1)


    }
}