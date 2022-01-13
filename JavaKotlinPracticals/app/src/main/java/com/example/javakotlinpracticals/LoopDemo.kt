package com.example.javakotlinpracticals

fun main() {
    println("For Loop Demos")

    //for loop 1 : increments by 1
    for (i in 1..5)
        print("$i\t")
    println()

    //for loop 2 : increments by 2 using step
    for (i in 1..5 step 2)
        print("$i\t")
    println()

    //for loop 3 : exclude the upper bound and increments by 1
    for (i in 1 until 5)
        print("$i\t")
    println()

    //for loop 4 : exclude the upper bound and increments by 2
    for (i in 1 until 5 step 2)
        print("$i\t")
    println()

    //for loop 5 : reverse iteration
    for (i in 10 downTo 1)
        print("$i\t")
    println()

    //for loop 6 : reverse iteration with 2 decrement
    for (i in 10 downTo 1 step 2)
        print("$i\t")
    println()

    println("While Loop Demo")
    //while loop 1
    var n = 5
    while (n >= 1) {
        print("$n\t")
        n--
    }
    println()

    //while loop 2
    var n1 = 1
    while (n1 <= 5) {
        print("$n1\t")
        n1++
    }

    //Infinite loop using while
    /*var n3=1
    while (n3 <= 5) {
        print("$n3\t")
     //   n1++
    }*/
    println()

    //print table using while loop
    print("Enter the no:")
    var no2 = readLine()!!//can't accept null value
    var i = 1
    while (i <= 10) {
        println("$no2 * $i = ${ no2.toInt() * i }")
        i++
    }

    //do while loop
    println("Do while loop")
    var j = 1
    do {
        println(j)
    }while (j > 1)//it executes once time loop if condition true or false

    //infinite loop using dowhile loop
    /*do{
        print("$j\t")
        j++
    }while (j>1)*/

    //break statement 1
    println("Break Statement")
    var k = 1
    for(k in 1..5) {
        if(k == 3)
            break
        print("$k\t")
    }
    println()

    //break statement 2 with labled
    //label can be given as labelname@
    outerloop@ for(i1 in 1..3)
        for(j1 in 1..3) {
            if(i1 == 2)
                break@outerloop
            println("i = $i1 and j = $j1")
        }

    //Continue statement
    println("Continue Statement")
    for (p in 1..3) {
        println("$p")
        if (p == 2) {
            continue
        }
        println("Out of if block")
    }
}
