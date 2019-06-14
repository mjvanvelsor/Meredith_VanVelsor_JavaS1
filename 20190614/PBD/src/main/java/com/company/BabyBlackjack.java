package com.company;

import java.sql.SQLOutput;
import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random randomGenerator = new Random();



        int player1 = randomGenerator.nextInt(9 + 1) + 1;
        int player2 = randomGenerator.nextInt(9 + 1) + 1;
        int sumPlayer = player1 + player2;

        System.out.println("Baby Blackjack!");
        System.out.println("You drew a " + player1 + " and " + player2 + ".\n");
        System.out.println("Your total is " + sumPlayer + ".");

        int dealer1 = randomGenerator.nextInt(9 + 1) + 1;
        int dealer2 = randomGenerator.nextInt(9 + 1) + 1;
        int sumDealer = dealer1 + dealer2;

        System.out.println("The dealer has " + dealer1 + " and " + dealer2 + ".\n");
        System.out.println("Dealer's total is " + sumDealer + ".");

        if (sumDealer > sumPlayer){
            System.out.println("Dealer wins!");
        } else {
            System.out.println("You win!");
        }
    }





}
