package com.trilogyed;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int totalAnswers = 0;

        System.out.println("Are you ready for a quiz?");
        String answer = myScanner.nextLine();
        System.out.println("Okay, here it comes!");

        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("1) Melbourne");
        System.out.println("2) Anchorage");
        System.out.println("3) Juneau");

        int answer1 = Integer.parseInt(myScanner.nextLine());

        if (answer1 != 3) {
            totalAnswers += 0;
            System.out.println("That's incorrect!");
        } else {
            totalAnswers += 1;
            System.out.println("That's right!");
        }

        System.out.println("Q2) Can you store the value 'cat' in a variable of type int?");
        System.out.println("1) yes");
        System.out.println("2) no");

        int answerCat = Integer.parseInt(myScanner.nextLine());

        if (answerCat != 1) {
            totalAnswers += 1;
            System.out.println("That's right!");
        } else {
            totalAnswers += 0;
            System.out.println("Sorry, 'cat' is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("1) 5");
        System.out.println("2) 11");
        System.out.println("3) 15/3");
        int answer3 = Integer.parseInt(myScanner.nextLine());

        if (answer3 != 2) {
            totalAnswers += 0;
        } else {
            totalAnswers += 1;
            System.out.println("That's correct!");
        }

        System.out.println("Overall, you got " + totalAnswers + " out of 3 correct.");
        System.out.println("Thanks for playing!");

    }
}
