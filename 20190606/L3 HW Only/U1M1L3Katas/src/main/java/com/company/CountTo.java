package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please input a number.");
        int userNum = myScanner.nextInt();

        for (int i = 0; i <= userNum; i++) {
            System.out.println(i);
        }

    }
}
