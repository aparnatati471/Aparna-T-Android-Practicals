package com.example.javakotlinpracticals;
//demo of abstrct class
abstract class Java{//abstract class created with abstract keyword and cant be instantiated
    String str="Class_Object_Inheritence_Polymorphisam";
    Java()//constructor called
    {
        System.out.println("Constructor called!");
    }
    abstract void oops();//abstract method with defination and its body can be written in child class which extends this abstract class
    static void Collection_framework()//static method called by using class name
    {
        System.out.println("This is a Collection method");
    }
    void Exception()//non abstract method called by using obj
    {
        System.out.println("This is a Exception method");
    }
    final void Interface()//abstract class also contains final class
    {
        System.out.println("This is a Final method for interface");
    }
}
class Concepts extends Java{//child class which extends abstract class and it contains abstract method body
    void oops()//abstract method implementation
    {
        System.out.println("This is a Object Oriented Programming Concepts"+str);
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        Java.Collection_framework();//call the static method
        Java obj=new Concepts();//we can't create object of abstract class
        obj.oops();//call abstract method
        obj.Exception();//call non abstract method
        obj.Interface();//call final method
    }
}
