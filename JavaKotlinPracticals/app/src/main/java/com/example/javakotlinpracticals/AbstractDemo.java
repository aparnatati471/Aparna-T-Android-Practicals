package com.example.javakotlinpracticals;

//Abstract Class Demo : abstract class created with abstract keyword and cant be instantiated
abstract class Java {
    String str = "Class_Object_Inheritence_Polymorphisam";

    Java() {
        System.out.println("Constructor called!");
    }

    //abstract method with definition and its body can be written in child class which extends this abstract class
    abstract void oops();

    //static method called by using class name
    static void Collection_framework() {
        System.out.println("This is a Collection method");
    }

    //non abstract method called by using obj
    void Exception() {
        System.out.println("This is a Exception method");
    }

    //abstract class also contains final class
    final void Interface() {
        System.out.println("This is a Final method for interface");
    }
}

//child class which extends abstract class and it contains abstract method body
class Concepts extends Java {
    void oops() {
        System.out.println("This is a Object Oriented Programming Concepts" +str);
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Java.Collection_framework();//call the static method
        Java obj = new Concepts();//we can't create object of abstract class
        obj.oops();//call abstract method
        obj.Exception();//call non abstract method
        obj.Interface();//call final method
    }
}
