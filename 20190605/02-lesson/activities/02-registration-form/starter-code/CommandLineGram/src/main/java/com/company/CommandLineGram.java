package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("First name");
        String firstName = myScanner.nextLine();

        System.out.println("Last name");
        String lastName = myScanner.nextLine();

        System.out.println("Email");
        String email = myScanner.nextLine();

        System.out.println("Twitter handle");
        String twitter = myScanner.nextLine();

        System.out.println("Age");
        String age = myScanner.nextLine();

        System.out.println("Country");
        String country = myScanner.nextLine();

        System.out.println("Profession");
        String profession = myScanner.nextLine();

        System.out.println("Favorite Operating System");
        String favOS = myScanner.nextLine();

        System.out.println("Favorite Programming Language");
        String favLang = myScanner.nextLine();

        System.out.println("Favorite Computer Scientist");
        String favCompSci = myScanner.nextLine();

        System.out.println("Favorite Keyboard Shortcut");
        String favShort = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String haveYou = myScanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String superhero = myScanner.nextLine();

        //Answers back
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Twitter handle: " + twitter);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Profession: " + profession);
        System.out.println("Favorite Operating System: " + favOS);
        System.out.println("Favorite Programming Language: " + favLang);
        System.out.println("Favorite Computer Scientist: " + favCompSci);
        System.out.println("Favorite Keyboard Language: " + favShort);
        System.out.println("Have you built your own computer? " + haveYou);
        System.out.println("If you were a superhero, you would be: " + superhero);

    }
}
