package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your favorite programming language?");
        String faveLang = myScanner.nextLine();

        boolean isFav = false;

        while (!isFav) {
            if (faveLang.equals("Java")) {
                System.out.println("That's what I was looking for! Java is definitely the answer!");
                isFav = true;
            } else {
                System.out.println("Guess again!");
                faveLang = myScanner.nextLine();
            }
        }
    }
}