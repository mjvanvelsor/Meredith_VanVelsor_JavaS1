package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number");
        float number = Integer.parseInt(myScanner.nextLine());
        float result = (number + 5) * 2;
        System.out.format("The result is %f", result);
    }
}
