package com.example.javakotlinpracticals

//Kotlin provides 2 classes Nested class and inner class
//nested class means a class created inside another class and it does not allow to access the outer class members
//inner class declared with inner class keyword and it allows to access the outer class members if it is private

class NestedInnerClassDemo {
    private var outerString = "Outer Class"

    inner class InnerClass {
        private var innerClassString = "Inner Class"
        fun disp() {
           println("Inner Class String : $innerClassString")
           println("Outer Class String : $outerString")
        }
    }

    //nested Class and by default nested class is static and it can be accessed via class name
    //no need to create objects for that
    class NestedClass
    {
        private var nestedClassString = "Nested Class"
        fun disp2() {
            println("Nested Class String : $nestedClassString")
           // println("Outer Class String : $outerString")
        }
    }
}

fun main() {
    var obj = NestedInnerClassDemo();
    println(obj.InnerClass().disp())
    println(NestedInnerClassDemo.NestedClass().disp2())
}