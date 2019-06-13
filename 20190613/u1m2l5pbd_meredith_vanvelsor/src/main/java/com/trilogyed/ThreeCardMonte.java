package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash. \n" +
                "He glances at you out of the corner of his eye and starts shuffling. \n" +
                "He lays down three cards.\n \n" +
                "Which one is the ace \n \n" +
                "           ##  ##  ## \n" +
                "           ##  ##  ## \n" +
                "           1   2   3 \n\n");

        int min = 1;
        int max = 3;
        int answer = randomGenerator.nextInt((max - min) + 1) + min;

        int userGuess = Integer.parseInt(myScanner.nextLine());

        if (userGuess == answer) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling. \n\n");
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + answer);
        }

        switch (answer) {
            case 1:
                System.out.println(
                        "           AA  ##  ## \n" +
                                "           AA  ##  ## \n" +
                                "           1   2   3 \n\n");
                break;
            case 2:
                System.out.println(
                        "           ##  AA  ## \n" +
                        "           ##  AA  ## \n" +
                        "           1   2   3 \n\n");
                break;
            case 3:
                System.out.println(
                        "           ##  ##  AA \n" +
                                "           ##  ##  AA \n" +
                                "           1   2   3 \n\n");
                break;
        }
    }
}
