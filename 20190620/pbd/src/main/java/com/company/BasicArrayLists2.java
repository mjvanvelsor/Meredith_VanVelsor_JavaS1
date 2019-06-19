package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        List<Integer> basicArray = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            int ranNum = randomGenerator.nextInt(100) + 1;
            basicArray.add(ranNum);
        }

        System.out.println("ArrayList: " + basicArray);

    }
}