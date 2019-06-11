package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);
        int max = 6;
        int min = 1;
        int randomNum = randomGenerator.nextInt((max - min) + 1) + min;
        int randomNum2 = randomGenerator.nextInt((max - min) + 1) + min;

        int sum = randomNum + randomNum2;
        System.out.println("Here comes the dice!");
        System.out.println("Roll #1: " + randomNum );
        System.out.println("Roll #2: " + randomNum2 );
        System.out.println("The total is " + sum + "!");
    }
}
