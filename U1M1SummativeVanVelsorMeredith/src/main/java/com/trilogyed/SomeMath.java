package com.trilogyed;

public class SomeMath {
    public static void main(String[] args) {
        System.out.println(total5(1, 2, 3, 4, 5));
        System.out.println(average5(1, 3, 5, 7, 9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));
    }

    //total5
    public static int total5(int a, int b, int c, int d, int e) {
        int totalSum = a + b + c + d + e;
        return totalSum;
    }

    //average5
    public static int average5(int a, int b, int c, int d, int e) {
        int average = (a + b + c + d + e) / 5;
        return average;
    }

    //largest5
    public static double largest5(double a, double b, double c, double d, double e) {

        double largest;             // must be double since parameters are double

        /*
        This method eliminates each declared parameter incrementally.
        Once it rules out the other doubles,
        it can declare which is largest.
         */

        if (a > b && a > c && a > d && a > e) {
            largest = a;
        } else if (b > c && b > d && b > e) {
            largest = b;
        } else if (c > d && c > e) {
            largest = c;
        } else if (d > e) {
            largest = d;
        } else {
            largest = e;
        }
        return largest;
    }
}
