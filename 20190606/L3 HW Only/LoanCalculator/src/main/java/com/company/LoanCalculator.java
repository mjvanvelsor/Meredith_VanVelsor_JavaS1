package com.company;

import java.util.Scanner;


public class LoanCalculator {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your total mortgage value?");

        double l = myScanner.nextDouble();
        System.out.println("What is the term of the mortgage?");

        double n = myScanner.nextDouble();
        System.out.println("What is the annual interest rate");

        double apr = myScanner.nextDouble();
        double c = (apr / 100) / 12;

        double p = ((Math.pow((1 + c), n) * c) * l / (Math.pow((1 + c), n) - 1));
        double adjP = Math.floor(p * 100) / 100;
        System.out.println("Total amount of mortgage payment is $" + adjP);

    }
}