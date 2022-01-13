package com.example.javakotlinpracticals

fun add() {
    var a = 10
    var b = 20
    println("Addition of $a and $b is : ${a + b}")
}

fun sub(no1: Int, no2: Int) {
    println("Subtraction of $no1 and $no2 : ${no1 - no2}")
}

fun mul(p: Int, q: Int): Int {
    return p * q
}

fun printNumbers(vararg numbers: IntArray) {
    for (number in numbers) {
        println(number)
    }
}

data class User(var name: String, var id: Int, var email: String)

//we can also write above statement like this
fun div(m: Int, n :Int): Int = m / n

fun main() {
    add()
    sub(20,10)
    var result= mul(10,2)
    println("Multiplication is $result")
    println("Division is ${div(20,2)}")

    val numbers = intArrayOf(1, 2, 3)
    printNumbers(numbers)

    val u = User("ABC", 1, "mymail@mail.com")
    println(u)
}

