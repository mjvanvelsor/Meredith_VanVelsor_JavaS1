package com.trilogy;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesToSevenBonus {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        System.out.println("How many times would you like to roll the dice?");
        int userNum = myScanner.nextInt();

        //    int i = 0;    No. of rolls
        int count2 = 0;  // No. of rolls = to 2
        int count3 = 0;  // No. of rolls = to 3
        int count4 = 0;  // No. of rolls = to 4
        int count5 = 0;  // No. of rolls = to 5
        int count6 = 0;  // No. of rolls = to 6
        int count7 = 0;  // No. of rolls = to 7
        int count8 = 0;  // No. of rolls = to 8
        int count9 = 0;  // No. of rolls = to 9
        int count10 = 0;  // No. of rolls = to 10
        int count11 = 0;  // No. of rolls = to 11
        int count12 = 0;  // No. of rolls = to 12

        boolean hasRolled7 = true;

        for (int i = 1; i <= userNum; i++) {
            int dice1 = randomGenerator.nextInt(6) + 1;
            int dice2 = randomGenerator.nextInt(6) + 1;
            int sum = (dice1 + dice2);

                if (sum == 2) count2++;
                if (sum == 3) count3++;
                if (sum == 4) count4++;
                if (sum == 5) count5++;
                if (sum == 6) count6++;
                if (sum == 7) { count7++;
                    if (hasRolled7 == true) {
                        System.out.println("It took you this many rolls to reach 7: " + i);
                        hasRolled7 = false;
                    }

            }

                if (sum == 8) count8++;
                if (sum == 9) count9++;
                if (sum == 10) count10++;
                if (sum == 11) count11++;
                if (sum == 12) count12++;

            System.out.println(dice1 + ", " + dice2 + ", total: " + sum + " roll: " + i);
        }

        System.out.println("Great job!");
        System.out.println("Total number of times sum equaled 2 was " + count2);
        System.out.println("Total number of times sum equaled 3 was " + count3);
        System.out.println("Total number of times sum equaled 4 was " + count4);
        System.out.println("Total number of times sum equaled 5 was " + count5);
        System.out.println("Total number of times sum equaled 6 was " + count6);
        System.out.println("Total number of times sum equaled 7 was " + count7);
        System.out.println("Total number of times sum equaled 8 was " + count8);
        System.out.println("Total number of times sum equaled 9 was " + count9);
        System.out.println("Total number of times sum equaled 10 was " + count10);
        System.out.println("Total number of times sum equaled 11 was " + count11);
        System.out.println("Total number of times sum equaled 12 was " + count12);
    }
}

