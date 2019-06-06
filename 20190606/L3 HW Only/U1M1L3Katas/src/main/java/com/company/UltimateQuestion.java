package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 100");
        int x = Integer.parseInt(myScanner.nextLine());

        while (x != 42 ) {
            System.out.println("Please enter another number.");
            x = Integer.parseInt(myScanner.nextLine());
        }

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
