package com.example.javakotlinpracticals

//Simple Interface Demo
interface demo {
    var id: Int
    fun demoAbstractMethod()
    fun display() {
        println("Interface Display")
    }
}

class InterfaceDemo: demo {
    override var id: Int = 10
    override fun demoAbstractMethod() {
        println("This is Abstract Method")
    }
}

//Multiple Inheritance Using Interface
interface i1 {
    fun i1Method()
}
interface i2 {
    fun i2Mthod()
}
class MultipleInheritance: i1, i2{
    override fun i1Method() {
        println("This is interface1 Method")
    }
    override fun i2Mthod() {
        println("This is interface2 Method")
    }
}

fun main()
{
    //Object creation for simple interface
    val obj = InterfaceDemo()
    println("Overriding Variable Value : ${ obj.id }")
    obj.display()
    obj.demoAbstractMethod()

    //Object creation for Multiple Inheritance
    val obj1 = MultipleInheritance()
    obj1.i1Method()
    obj1.i2Mthod()
}