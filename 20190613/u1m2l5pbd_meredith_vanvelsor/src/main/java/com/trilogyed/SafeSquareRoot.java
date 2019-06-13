package com.trilogyed;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);


        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number: " + "\r");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        while (userNumber < 0d) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.println("Try again:" + "\r");
            userNumber = Integer.parseInt(myScanner.nextLine());
        }

        if (userNumber > 0d) {
            double sqRoot = Math.sqrt(userNumber);
            System.out.println("The square root of " + userNumber + " is " + sqRoot);
        }

    }
}
