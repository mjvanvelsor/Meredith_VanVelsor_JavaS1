package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number between 15 and 32 (not inclusive)");
        int x = Integer.parseInt(myScanner.nextLine());

        while (x < 16 || x > 31) {
            System.out.println("Please enter another number.");
            x = Integer.parseInt(myScanner.nextLine());
        }

        System.out.println("Your number is " + x);
    }
}


