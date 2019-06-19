package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        List<Integer> basicArray = new ArrayList<>();


        for (int i = 0; i < 1000; i++) {
            int ranNum = randomGenerator.nextInt(90) + 10;
            basicArray.add(ranNum);
        }

        System.out.println("ArrayList: " + basicArray);

    }
}