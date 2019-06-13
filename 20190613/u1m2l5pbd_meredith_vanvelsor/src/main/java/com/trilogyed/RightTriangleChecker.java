package com.trilogyed;

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter three integers:");

        int side1, side2, side3;

        System.out.println("Side 1: ");
        side1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Side 2: ");
        side2 = Integer.parseInt(myScanner.nextLine());

        while (side2 < side1) {
            System.out.println(side2 + " is smaller than " + side1 + ", try again.");
            System.out.println("Side 2: ");
            side2 = Integer.parseInt(myScanner.nextLine());
        }

        System.out.println("Side 3: ");
        side3 = Integer.parseInt(myScanner.nextLine());

        while (side3 < side2) {
            System.out.println(side3 + " is smaller than " + side2 + ", try again.");
            System.out.println("Side 3: ");
            side3 = Integer.parseInt(myScanner.nextLine());
        }

        double rightTri = Math.sqrt(side1 * side1 + side2 * side2);

        if (rightTri == side3) {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        } else {
            System.out.println("Your three sides are " + side1 + ", " + side2 + ", " + side3 + ".");
            System.out.println("NO! These sides do not make a right triangle!");
        }
    }
}