package com.example.javakotlinpracticals

fun main()
{
    //readLine() is used to take input from user
    println("Enter the name:")
    var name = readLine()

    println("Enter the age:")
    var age = Integer.valueOf(readLine())

    //do explicitly
    println("Your name is $name and age is $age")
    var editedAge = age + 20
    println("Edited Age $editedAge")
}