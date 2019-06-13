package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class DiceDoubles {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);

        int randomNum = 1;      // temp value, not printed
        int randomNum2 = 2;     // temp value, not printed
        int sum;

     while ( randomNum != randomNum2){
         randomNum = randomGenerator.nextInt((6) + 1);
         randomNum2 = randomGenerator.nextInt((6) + 1);
         sum = randomNum + randomNum2;
         System.out.println("Here comes the dice!");
         System.out.println("Roll #1: " + randomNum);
         System.out.println("Roll #2: " + randomNum2);
         System.out.println("The total is " + sum + "!\n");
        }

    }
}