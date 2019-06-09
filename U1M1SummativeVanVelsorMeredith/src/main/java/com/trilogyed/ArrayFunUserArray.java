package com.trilogyed;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] userArray = new int[5];

        for (int i = 0; i < userArray.length; i++) {
            System.out.println("Please enter a whole number.");
            int userNumber = myScanner.nextInt();
            userArray[i] = userNumber;
        }
        for (int i = 0; i < userArray.length; i++){
            System.out.println(userArray[i]);
        }
    }
}
