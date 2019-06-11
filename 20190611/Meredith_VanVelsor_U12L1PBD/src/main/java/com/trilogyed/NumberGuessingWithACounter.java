package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);
        int max = 10;
        int min = 1;
        int randomNum = randomGenerator.nextInt((max - min) + 1) + min;

        System.out.println("I have chosen a number between 1 to 10. Try to guess it.");
        int userGuess = Integer.parseInt(myScanner.nextLine());
        int counter = 1;

        while (userGuess != randomNum && counter >= 0) {
            System.out.println("Your guess: " + userGuess);
            System.out.println("That is incorrect. Guess again");
            userGuess = Integer.parseInt(myScanner.nextLine());
            counter++;
        }

        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you " + counter + " tries.");

    }
}

