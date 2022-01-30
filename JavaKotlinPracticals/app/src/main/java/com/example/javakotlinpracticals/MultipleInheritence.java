package com.example.javakotlinpracticals;

//Multiple Inheritance Using interface
interface web {
    void PHP();

    //by using default keyword we can write method body
    default void example() {
        System.out.println("PHP Interface");
    }
}

interface app {
    void Android();
}

class demo implements web, app {

    @Override
    public void PHP() {
        System.out.println("PHP for web application");
    }

    @Override
    public void Android() {
        System.out.println("Android for Android application");
    }
}

public class MultipleInheritence {
    public static void main(String[] args) {
        demo obj = new demo();
        obj.PHP();//call php method
        obj.Android();//call android method
        obj.example();//call example
    }
}
