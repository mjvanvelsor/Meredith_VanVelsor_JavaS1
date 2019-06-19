package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {
    public static void main(String[] args) {
        List<Integer> basicArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            basicArray.add(-113);
            System.out.println("Slot " + i + " contains a " + basicArray.get(0));
        }
    }
}