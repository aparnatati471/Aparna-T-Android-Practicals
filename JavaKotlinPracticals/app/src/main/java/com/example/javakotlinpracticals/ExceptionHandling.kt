package com.example.javakotlinpracticals

import java.lang.ArithmeticException
import java.lang.Exception

fun main()
{
    //simple try catch
    try {
        var a = arrayOf(10, 20, 30, 0)
        //var c=a[0]/a[3]
        a.set(4, 50)
    } catch (e:Exception) {
        println(e)
    }

    //nested try catch
    var numerator = intArrayOf(10, 20, 30, 40, 50, 90)
    var denometer = intArrayOf(2, 0, 2, 0, 2)
    try {
        for (i in numerator.indices) {
            try {
                println(numerator[i].toString()+"/"+denometer[i]+" is:" +numerator[i] / denometer[i])
            } catch (e:ArithmeticException) {
                println("You can't divide by zero!")
            }
        }
    } catch (e:ArrayIndexOutOfBoundsException) {
        println("Element Not Found")
    }
}