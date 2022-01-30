package com.example.javakotlinpracticals

class ClassAndObjectDemo {
    var a = 10
    fun demo() {
        println("This is demo function! $a")
    }
}

fun main() {
    var obj = ClassAndObjectDemo()
    obj.demo()
}