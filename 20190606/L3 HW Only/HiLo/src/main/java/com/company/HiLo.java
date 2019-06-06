package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("Welcome to Hi-Low!");
        System.out.println("What is your name?");
        String userName = myScanner.nextLine();
        System.out.println("OK, " + userName + ", here are the rules:");
        System.out.println("The computer will come up with a number between 1 and 100 (inclusive). \n " +
                "The user will be prompted to guess the number. \n " +
                "If the user guesses correctly, the program will let you know. \n");

        int answer = randomGenerator.nextInt(100) + 1;

        System.out.println("Please guess a number.");
        System.out.println(answer);
        int userGuess = Integer.parseInt(myScanner.nextLine());
        int i = 0;

        while (userGuess != answer) {
            if (userGuess < answer) {
                System.out.println("Too low!");
                System.out.println("Try again!");
                userGuess = Integer.parseInt(myScanner.nextLine());
                i++;
            } else if (userGuess > answer) {
                System.out.println("Too high!");
                System.out.println("Try again!");
                userGuess = Integer.parseInt(myScanner.nextLine());
                i++;
            }
        }
        System.out.println("Congratulations, " + userName + "! You win!");
        System.out.println("It took you " + i + " guesses to find my number!");
    }
}


