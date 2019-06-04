package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one integer.");
        float a = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float b = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float c = Integer.parseInt(myScanner.nextLine());
        float avg = (a + b + c) / 3;
        System.out.format("The average is %f", avg);
    }
}
