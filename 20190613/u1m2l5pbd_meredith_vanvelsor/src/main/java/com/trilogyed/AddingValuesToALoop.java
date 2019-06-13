package com.trilogyed;

import java.util.Scanner;

public class AddingValuesToALoop {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("I will add up the numbers you give me.\n");
        System.out.print("Number: ");
        int userInt = Integer.parseInt(myScanner.nextLine());

        int total = 0;

        while (userInt != 0) {
            System.out.print("The total so far is " + (total += userInt));
            System.out.print("\nNumber: ");
            userInt = Integer.parseInt(myScanner.nextLine());
        }

        System.out.println("The total is " + total);
    }
}
