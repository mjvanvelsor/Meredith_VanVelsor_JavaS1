package com.trilogyed;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int max = 6;
        int min = 1;
        int randomNum = randomGenerator.nextInt((max - min) + 1) + min;

        System.out.println("Fortune cookie says: ");

        if (randomNum == 1) {
            System.out.println("You will marry Kesh.");
        } else if (randomNum == 2) {
            System.out.println("You will live to be 100 years old.");
        } else if (randomNum == 3) {
            System.out.println("You will find great success.");
        } else if (randomNum == 4) {
            System.out.println("Your luck will soon change.");
        } else if (randomNum == 5) {
            System.out.println("An apple a day keeps the doctor away.");
        } else {
            System.out.println("Just keep swimming!");
        }
        int maxLotto = 54;
        int minLotto = 1;
        int randomLotto1 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;
        int randomLotto2 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;
        int randomLotto3 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;
        int randomLotto4 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;
        int randomLotto5 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;
        int randomLotto6 = randomGenerator.nextInt((maxLotto - minLotto) + 1) + minLotto;

        System.out.println(randomLotto1 + " - " + randomLotto2 + " - " + randomLotto3 + " - "
                + randomLotto4 + " - " + randomLotto5 + " - " + randomLotto6);
    }
}
