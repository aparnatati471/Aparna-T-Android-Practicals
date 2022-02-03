package com.example.javakotlinpracticals;

interface language {
    void java();
    static void kotlin() {
        System.out.println("This is Kotlin Programming");
    }
}

class programming implements language {
    @Override
    public void java() {
        System.out.println("This is Java Programming");
    }
}

public class Interface {
    public static void main(String[] args) {
        programming obj = new programming();
        obj.java();
        language.kotlin();
    }
}
