package com.example.javakotlinpracticals

//two constructors primary and secondary
//primary Constructor there is only one primary constructor and also primary constructor does not
//have any code so init block is used to write the code

class ConstructorDemo(id: Int, name: String) {
    private var empId: Int = 0
    var empName: String = ""

    init {
        empId = id
        empName = name.uppercase()
        println("Id: $empId \nName: $empName")
    }
}

//secondary constructor
//there are more than one secondary constructor in class and created using constructor keyword
class SecondaryConstructor {
    constructor(id: Int, name: String) {
        println("Id : $id\nName : $name")
    }
}

//we can also use primary and secondary constructor in same class
//secondary constructor needs to authorize to primary constructor using this() keyword
class PrimarySecondaryConstructor(salary: Int) {
    constructor(id: Int, name: String, salary: Int): this(salary) {
        println("Id : $id\nName : $name\nSalary : $salary")
    }
}

//we can also call one secondary constructor to another secondary constructor of same class
class OneToAnotherSecondary {
    constructor(id: Int, name: String): this(id, name,400000) {
        //println("Id : $id\nName : $name")
    }
    constructor(id: Int, name: String, salary: Int) {
        println("Id : $id\nName : $name\nSalary : $salary")
    }
}

fun main() {
    var pObj1 = ConstructorDemo(1,"abc")
    var pObj2 = ConstructorDemo(2,"pQr")

    var sObj1 = SecondaryConstructor(3,"MNO")

    var psObj1 = PrimarySecondaryConstructor(4,"GHI",200000)

    var stsObj1 = OneToAnotherSecondary(5,"EF")
}