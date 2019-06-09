package com.trilogyed;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String[] userWord = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter a word.");
            String userInput = myScanner.nextLine();
            userWord[i] = userInput;
        }
        for (int i = 0; i < userWord.length; i++){
            System.out.println(userWord[i]);
        }
    }
}
