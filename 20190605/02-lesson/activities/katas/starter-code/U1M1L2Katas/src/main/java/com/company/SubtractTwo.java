package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one integer.");
        float a = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter one integer to subtract.");
        float b = Integer.parseInt(myScanner.nextLine());

        float difference = a - b;
        System.out.format("The difference is %.0f", difference);
    }
}
