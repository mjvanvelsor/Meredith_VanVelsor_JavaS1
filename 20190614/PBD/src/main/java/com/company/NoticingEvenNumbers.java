package com.company;

public class NoticingEvenNumbers {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++){
            if (i % 2 == 0) {
                System.out.println(i + " <");
            } else {
                System.out.println(i);
            }
        }
    }

}
