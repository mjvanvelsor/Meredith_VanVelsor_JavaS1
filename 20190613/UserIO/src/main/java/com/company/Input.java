package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner myScanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.println("Enter an integer");
        int userInt = Integer.parseInt(myScanner.nextLine());
        return userInt;
    }

    public long readLong(String prompt) {
        System.out.println("Enter a long");
        long userLong = Long.parseLong(myScanner.nextLine());
        return userLong;
    }

    public double readDouble(String prompt) {
        System.out.println("Enter a double");
        double userDouble = Double.parseDouble(myScanner.nextLine());
        return userDouble;
    }

    public float readFloat(String prompt) {
        System.out.println("Enter a float");
        float userFloat = Float.parseFloat(myScanner.nextLine());
        return userFloat;
    }

    public String readString(String prompt) {
        System.out.println("Enter a string");
        String userString = (myScanner.nextLine());
        return userString;
    }
}
