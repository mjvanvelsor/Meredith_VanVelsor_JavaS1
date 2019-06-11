package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class ANumbersGuessingGame {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);
        int max = 10;
        int min = 1;
        int randomNum = randomGenerator.nextInt((max - min) + 1) + min;

        System.out.println("I'm thinking of a number from 1 to 10.");
        int userGuess = Integer.parseInt(myScanner.nextLine());

        if (userGuess != randomNum) {
            System.out.println("Sorry, but I was really thinking of " + randomNum + ".");
        } else {
            System.out.println("That's right! My secret number was " + randomNum + "!");
        }

    }
}
