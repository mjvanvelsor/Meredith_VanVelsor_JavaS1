package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one integer.");
        float a = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float b = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float c = Integer.parseInt(myScanner.nextLine());

        float product = a * b * c;
        System.out.format("The product is %f", product);

    }
}