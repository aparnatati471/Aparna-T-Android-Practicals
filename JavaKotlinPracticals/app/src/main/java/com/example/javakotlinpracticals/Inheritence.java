package com.example.javakotlinpracticals;

class A {
   void msg() {
       System.out.println("This is Class A");
   }
}
public class Inheritence extends A {

    void disp() {
        System.out.println("This is Class Inheritence");
    }

    public static void main(String args[]) {
        Inheritence obj = new Inheritence();
        obj.msg();
        obj.disp();
    }
}
