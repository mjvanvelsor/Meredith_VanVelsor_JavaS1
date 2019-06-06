package com.company;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                System.out.println("FIZZBUZZ");
            } else if (i % 5 == 0) {
                System.out.println("BUZZ");
            } else if (i % 3 == 0) {
                System.out.println("FIZZ");
            } else {
                System.out.println(i);
            }
        }
    }
}
