package com.example.javakotlinpracticals

//Kotlin classes are final by default,they can't inherited so open keyword allows class to be inherited by other class and make it classes are non final

//Inheritance Example 1
open class InheritanceDemo {
    val a: Int = 20
}

// Simple Inheritance demo 1 , : symbol is used to inherit class
class Derived1: InheritanceDemo() {
    fun display() {
        println("a is equal to $a")
    }
}

//Inheritance Example 2 with their primary constructors
open class Parent {
    init {
        println("Parent's Constructor Called!")
    }
    fun parentMethod() {
        println("Parent's Method Called!")
    }
}

class Child: Parent() {
    init {
        println("Child's Constructor Called!")
    }
    fun childMethod() {
        println("Child's Method Called!")
    }
}

//Inheritance Example 3 with their primary constructors and having same parameters
open class Payment(id: Int, amount: Int) {
    init {
        println("Id : $id\nAmount : $amount")
    }
}

class Card(id:Int, amount: Int): Payment(id, amount) {
    fun cardDetails(cardNo: Int, cardType: String) {
        println("Card No : $cardNo\nCardType : $cardType")
    }
}

class Cheque(id: Int,amount: Int): Payment(id, amount) {
    fun chequeDetails(chequeNo: Int, chequeType: String) {
        println("Cheque No : $chequeNo\nCheque Type : $chequeType")
    }
}

//Inheritance Example 4 with secondary constructor it is required to call constructor using super keyword
open class Parent2 {
    constructor(id: Int, name: String) {
        println("Super Class constructor \nId : $id\nName : $name")
    }
}

class Child2: Parent2 {
    constructor(id: Int, name: String, dept:String): super(id,name) {
        println("Sub Class Constructor \nId : $id\nName : $name\nDepartment : $dept")
    }
}

//Inheritance Example 5 Method Overriding
//method going to be override must be declare as open
//method overridden must be declare as override
open class Parent3 {
    open fun parentMethod() {
        println("This is a parent Method")
    }
}

class Child3: Parent3() {
    override fun parentMethod() {
        println("This is Child3 Method")
    }
}

class Child4: Parent3() {
    override fun parentMethod() {
        println("This is Child4 Method")
    }
}

//main function
fun main()
{
    //Object Creation for Inheritance Example 1
    val obj1 = Derived1()
    obj1.display()

    //Object Creation for Inheritance Example 2
    val cObj = Child()
    cObj.parentMethod()
    cObj.childMethod()

    //Object Creation for Inheritance Example 3
    val obj3 = Card(1,5000)
    obj3.cardDetails(1234567,"Debit Card")
    val obj4 = Cheque(2,10000)
    obj4.chequeDetails(835785628,"Open Cheque")

    //Object Creation for Inheritance Example 4
    val obj5 = Child2(1,"Rita","Design")

    //Object Creation for Inheritance Example 4
    val c3 = Child3()
    c3.parentMethod()
    val c4 = Child4()
    c4.parentMethod()
}