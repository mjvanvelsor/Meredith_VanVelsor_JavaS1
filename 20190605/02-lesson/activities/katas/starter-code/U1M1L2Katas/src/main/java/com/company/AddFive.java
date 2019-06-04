package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one integer.");
        float a = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float b = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float c = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float d = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer.");
        float e = Integer.parseInt(myScanner.nextLine());

        float sum = a + b + c + d + e;
        System.out.format("The sum is %f", sum);

    }
}
