package com.trilogy;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesToSeven {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

     //    int i = 0;       No. of rolls
        int count = 0;  // No. of rolls = to 7

        for (int i = 1; i <= 100; i++){
            int dice1 = randomGenerator.nextInt(6) + 1;
            int dice2 = randomGenerator.nextInt(6) + 1;
            int sum = (dice1 + dice2);
                if (sum==7) count++;
            System.out.println(dice1 + ", " + dice2 + ", total: " + sum + " roll: " + i);
        }

        System.out.println("Total number of times sum equaled 7 was " + count);


    }
}
