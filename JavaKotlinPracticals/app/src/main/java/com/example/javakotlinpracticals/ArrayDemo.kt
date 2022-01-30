package com.example.javakotlinpracticals

fun main() {

    //Many ways of Arrays Declaration and Intialization
    val arrLang = arrayOf("Java", "Kotlin", "Swift")
    var arrNum = arrayOf(10, 20, 30)
    var arrString = arrayOf<String>("One", "Two", "Three")
    var arrInt = arrayOf<Int>(1, 2, 3, 5)
    var arrIntString = arrayOf(1, 2, 3, "Java", "Kotlin")

    //printing array
    for(i in arrIntString)
        println(i)

    //printing array with their index i stands index and e stands element
    for((i,e) in arrLang.withIndex()) {
        println("$i $e")
    }

    //Get Element And Set Element
    println(arrInt[2])
    println(arrNum.get(1))

    arrString[2] = "Four"
    println(arrString.get(2));

    arrNum.set(2, 60)
    println(arrNum.get(2))

    for(i in arrNum)
        println(i)

    for(i in arrString)
        println(i)

    //using indices which returns int range
    for(i in arrNum.indices)
        println(arrNum[i])

    //using range
    for(i in 0..arrString.size)
        println(arrString[i])
}