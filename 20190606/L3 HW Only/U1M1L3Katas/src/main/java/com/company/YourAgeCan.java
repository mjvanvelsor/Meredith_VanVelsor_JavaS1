package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());

        String vote = "vote";
        String drink = "alcohol";
        String bePres = "president";
        String aarp = "aarp";
        String retire = "retire";
        String octo = "octogenarian";
        String century = "century";

        if (age >= 18 && age < 21) {
            System.out.println("You can " + vote + "!");
        } else if (age >= 21 && age < 35) {
            System.out.println("You can " + vote + " & " + drink + "!");
        } else if (age >= 35 && age <55) {
            System.out.println("You can " + vote + " & " + drink + " & be " + bePres + "!");
        } else if (age >= 55 && age <65) {
            System.out.println("You can " + vote + " & " + drink + " & be " + bePres + " & have " + aarp + "!");
        } else if ((age >= 65 && age <80 ) || ( age >90 && age< 100)) {
            System.out.println("You can " + vote + " & " + drink + " & be " + bePres + " & have " + aarp + " & " + retire +"!");
        } else if (age >= 80 && age <90) {
            System.out.println("You can " + vote + " & " + drink + " & be " + bePres + " & have " + aarp + " & " + retire + " & are an" + octo + "!");
        }  else if (age >= 100) {
            System.out.println("You can " + vote + " & " + drink + " & be " + bePres + " & have " + aarp + " & " + retire + " & are atleast a" + century + " old!");
        }
    }
}
