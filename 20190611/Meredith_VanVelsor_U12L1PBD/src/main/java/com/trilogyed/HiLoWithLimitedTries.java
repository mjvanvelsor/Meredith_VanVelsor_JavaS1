package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);
        int max = 100;
        int min = 1;
        int randomNum = randomGenerator.nextInt((max - min) + 1) + min;

        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");
        int userGuess = Integer.parseInt(myScanner.nextLine());
        int guessCounter = 1;

        while (userGuess != randomNum && guessCounter < 7) {

            if (userGuess < randomNum) {
                System.out.println("Sorry, you are too low.");
                System.out.println("Guess #" + guessCounter + ": " + userGuess);
                userGuess = Integer.parseInt(myScanner.nextLine());
                guessCounter++;

            } else if (userGuess > randomNum) {
                System.out.println("Sorry, you are too high.");
                System.out.println("Guess #" + guessCounter + ": " + userGuess);
                userGuess = Integer.parseInt(myScanner.nextLine());
                guessCounter++;
            }
        }

        if (userGuess == randomNum) {
            System.out.println("You guessed it! What are the odds?!?");
        } else {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        }
    }
}

