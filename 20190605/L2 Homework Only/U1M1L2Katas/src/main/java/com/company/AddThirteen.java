package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one integer.");
        float a = Integer.parseInt(myScanner.nextLine());
        float sum = (a + 13);
        System.out.format("The sum is %f", sum);
    }
}
