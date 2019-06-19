package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingValueInAnArrayList {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);
        List<Integer> basicArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int ranNum = randomGenerator.nextInt(50) + 1;
            basicArray.add(ranNum);
        }

        System.out.println("ArrayList: " + basicArray);

        System.out.println("Value to find: ");
        int userInput = Integer.parseInt(myScanner.nextLine());

        for(int i = 0; i < basicArray.size(); i++){
            if (basicArray.get(i) == userInput){
                System.out.println(userInput + " is in the ArrayList.");
            }
        }
    }
}