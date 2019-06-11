package com.trilogyed;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your earth weight?");
        float earthWeight = Float.parseFloat(myScanner.nextLine());
        System.out.println("I have information for the following planets: " + "1: Venus " +
                "2: Mars " + "3: Jupiter " + "4: Saturn " + "5: Uranus " + "6: Neptune");
        System.out.println("Please enter a number for the planet you would like to fight on.");
        float planet = Float.parseFloat(myScanner.nextLine());
        float spaceWeight = 0;

        if (planet == 1) {
            spaceWeight = earthWeight * 0.78f;
        } else if (planet == 2) {
            spaceWeight = earthWeight * 0.39f;
        } else if (planet == 3) {
            spaceWeight = earthWeight * 2.65f;
        } else if (planet == 4) {
            spaceWeight = earthWeight * 1.17f;
        } else if (planet == 5) {
            spaceWeight = earthWeight * 1.05f;
        } else if (planet == 6) {
            spaceWeight = earthWeight * 1.23f;
        } else {
            System.out.println("Please enter a number between 1 and 6.");
        }

        System.out.printf("Your weight would be %.2f pounds on that planet.", spaceWeight);


    }
}
