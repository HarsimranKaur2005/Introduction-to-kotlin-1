package com.example.intro_to_kotlin_2


//Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts in your design.Also try to use interfaces and abstract classes.

interface library_interface{
    fun removeBook()
}

abstract  class library_abstract{


    abstract fun add(id:Int,bookname:String,author:String)
    abstract fun getdetails()
}
class question4:library_abstract(),library_interface{
    var count =0
    var Id:Int=0
    var name:String =" "
    var author:String=" "
    override fun add(id:Int,bookname:String,auth:String)
    {
        Id=id
        name = bookname
        author = auth
        count++
        println("$name book is added")
    }

    override fun removeBook() {
        count--
        println("A book is removed")
    }

    fun totalbook(){
        println("Total books in library left: $count")
    }


    override fun getdetails() {
        println("ID: "+ Id + " Book Name: "+ name+ " Author Name: "+ author)
    }




}