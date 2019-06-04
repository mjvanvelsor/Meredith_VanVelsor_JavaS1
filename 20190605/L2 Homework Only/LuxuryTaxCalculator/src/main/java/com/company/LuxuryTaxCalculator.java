package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the salary of Player 1?");
        float player1 = Float.parseFloat(myScanner.nextLine());
        System.out.println("What is the salary of Player 2?");
        float player2 = Float.parseFloat(myScanner.nextLine());
        System.out.println("What is the salary of Player 3?");
        float player3 = Float.parseFloat(myScanner.nextLine());

        float sum = player1 + player2 + player3;
        System.out.format("The total salary of all players is %.2f.", sum);

//everything above here passes

        float difference = sum - 40000000;
        float product = difference * (.18f);

        if (sum <= 40000000) {
            System.out.println("You are within your budget.");
        }

        if (sum > 40000000) {
            System.out.println("You are overbudget and must pay taxes.");
            System.out.format("Your total in taxes will be %.2f", product);
        }

        }
    }
