package com.example.javakotlinpracticals

fun main() {
    //null safety example
    var a: String? = null//? says that a can be null or any string value and compiler will not throw null pointer exception
    println(a)

    //non nullable types
    var b: String?="hello"//if you are going to assign null without ? then it will give compiler error
    //b=null
    println(b)

    //null safety example 2
    var length = if (a != null) a.length else -1
    println("String is: $a")
    println("Length is: $length")

    //null safety example 3
    var len = if (b != null) b.length else -1
    println("String is: $b")
    println("Length is: $len")

    //let does if a is null then it will not allowed to execute a block
    a?.let { 
        var c:String = "C"
        var d:String = "D"
    }
}