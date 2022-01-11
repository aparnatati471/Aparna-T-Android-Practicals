package com.example.javakotlinpracticals;

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        int a, b;
        int arr[] = new int[2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Value of a:");
        a=sc.nextInt();

        System.out.println("Enter The Value of b:");
        b=sc.nextInt();

        try {
            int result=a/b;
            String str=null;
            System.out.println(str.length());
            //arr[3]=10;
        } catch(Exception e) {
            System.out.println("Exception : " +e);
        } finally {
            System.out.println("No exceptions!");
        }
    }
}
