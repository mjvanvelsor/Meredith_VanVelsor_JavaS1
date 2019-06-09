package com.trilogyed;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 10.");
        int userGuess = Integer.parseInt(myScanner.nextLine());

        if (userGuess < 1 || userGuess > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
        } else {
            System.out.println(userGuess);
        }
    }
}
