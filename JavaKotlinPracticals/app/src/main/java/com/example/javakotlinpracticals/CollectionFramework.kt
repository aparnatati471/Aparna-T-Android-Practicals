package com.example.javakotlinpracticals

fun listInterface() {
    //list is immutable and maintains insertion sequence order and listOf() method is used
    //simple list creation and its printing and pass data of same type
    val list = listOf("Java", "Kotlin", "Swift")

    //1st way print elements
    for(item in list)
        println(item)

    //we can also pass data of different type in listOf() method
    val list1 = listOf(1, 2, 3, "Java", "Kotlin", "Swift")

    //2nd way print elements
    for(i in 0..list1.size - 1)
        println(list1[i])

    //we can also provide generics to list
    val intList2: List<Int> = listOf(1, 2, 3)
    val intList3: List<String> = listOf("Class", "Object", "Inheritence", "Object")
    val intList4: List<Any> = listOf(1, 2, 3, "Class", "Object", "Inheritence")

    //Different Operations

    //to get elements
    println(intList2.get(1))
    println(intList2[1])

    //to print index of particular item
    println(intList3.indexOf("Object"))
    println(intList3.lastIndexOf("Object"))

    //size of list
    println(intList3.size)

    //to check whether list contains item or not
    println(intList2.contains(2))

    //returns part of list fromindex is inclusive but toindex is exclusive
    println(intList4.subList(1, 4))

    //to check list is empty or not
    println(intList2.isEmpty())
}

fun mutableList() {
    //comes as solution for list interface
    var mutableList = mutableListOf("OOPS", "Class", "Object", "Inheritance")
    for(item in mutableList)
        println(item)

    //Add Elements
    mutableList.add("Polymorphisam")
    mutableList.add(2,"Super")
    println(mutableList)

    var mutableList1 = mutableListOf("This", "Exception Handling")

    ///add complete list to another list
    mutableList.addAll(mutableList1)
    println(mutableList)

    //Remove Elements
    mutableList.removeAt(1)
    mutableList.remove("OOPS")

    //set element at specified index
    mutableList.set(0, "OOPS")

    //mutableList.clear()//clear all elements

    //returns sublist
    mutableList.subList(1, 3)//returns sublist
}

fun arrayList() {
    //used to create dynamic array maintains insertion order
    val arrList = arrayListOf("C", "C++", "JAVA", "PHP")

    arrList.add("Swift")
    println(arrList.size)

    var mutableList = mutableListOf("OOPS", "Class", "Object", "Inheritance")

    //add complete list to arraylist
    arrList.addAll(mutableList)

    //get particular element at specified index
    println(arrList.get(2))
    println(arrList[2])

    //arrList.set(9,"Swift")//set element at specified index
    arrList[7] = "Swift"

    ////returns index of first and last occurrence of element
    println(arrList.indexOf("Swift"))
    println(arrList.lastIndexOf("Swift"))

    //Remove Elements
    arrList.remove("Swift")
    arrList.removeAt(2)

    ///arrList.clear()//remove all the elements
}

fun map() {
    val map:Map<Int,String> = mapOf(1 to "JAVA", 2 to "kotlin", 3 to "Swift")
    for(i in map.keys)
        println(map[i])

    //print key and value
    for(i in map.keys)
        println("Item at $i index and its value is ${ map[i] }")

    //Get Elements
    println(map.get(1))
    println(map.getValue(2))//retrive value for key 2
    println(map.containsKey(1))//to check whether specified key is present or not
    println(map.contains(2))
    println(map.containsValue("JAVA"))//to check whether value is present or not

    ///minus exclude the element for printing
    for(i in map.minus(2))
        println(map[i.key])

    for(i in map.plus(Pair(4,"IOS")))
        println("Element at ${ i.key } is ${ i.value }")
}

fun hashmapDemo() {
    val hashMap=HashMap<Int,String>()

    //add elements
    hashMap.put(1, "IT")
    hashMap.put(2, "Computer")
    hashMap.put(3, "EC")

    //print the elements
    for(i in hashMap.keys)
        println("Index $i Value is ${ hashMap[i] }")

    //hashMap.remove(1)//remove IT
    println(hashMap.containsKey(2))//to check whether key present or not
    println(hashMap.containsValue("IT"))//to check whether value present or not
    //hashMap.clear()//clear all the entries
}

fun main() {
    listInterface()
    mutableList()
    arrayList()
    map()
    hashmapDemo()
}