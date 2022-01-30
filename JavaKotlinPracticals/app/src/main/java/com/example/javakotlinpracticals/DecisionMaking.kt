package com.example.javakotlinpracticals

fun main() {

    //Simple if
    println("Simple If Statement")
    var expr = true
    if(expr)
        println("True Statement")

    //If..else
    println("If..else statement")
    var a = 10
    var b = 20
    if(a > b)
        println("$a is greater than $b")
    else
        println("$a is smaller than $b")

    //kotlin does not support ternary operator instead it provide if else statement in one line
    println("Ternary operator as if..else")
    var result = if (a > b) "$a is greater than $b" else "$b is greater than $b"

    //if else if else ladder
    println("If..else if..else ladder statement")
    var no = if (a > 0) {
        println("$a is positive number")
    } else if (a < 0) {
        println("$a is negative number")
    } else {
        println("$a is zero")
    }

    //When statement it is like switch statement
    var no1 = 1
    when(no1) {
        1-> print("Java")
        2-> print("Kotlin")
        3-> print("Swift")
        4-> print("IOS")
        else-> print("Enter number between 1 to 4")
    }

    //when allows to print multiple statements
    when(no1) {
        1 -> {
            print("Java")
            print("OOPS")
        }
        2 -> print("Kotlin")
        3 -> print("Swift")
        4 -> print("IOS")
        else -> print("Enter number between 1 to 4")
    }

    //when allows to use multiple branches of condition
    when(no1) {
        1, 2, 3, 4 -> print("Winter Season")
        5, 6, 7, 8 -> print("Summer Season")
        9, 10, 11, 12 -> print("Rainy Season")
        else -> print("Enter number between 1 to 12")
    }

    //when using range
    when(no1) {
        in 1..5 -> print("no1 is provided in range 1 to 5")
        in 6..10 -> print("no1 is provided in range 6 to 10")
        else -> print("None of the above")
    }
}