package com.company;

import java.util.LinkedList;

public class LinkedListApp {

    public static int total (LinkedList<Integer> numbers) {

        int sum = 0;
        for(Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {

        int arraySize = strings.size();

        String temp = strings.get(0);
        strings.set(0, strings.get(arraySize - 1));
        strings.set(arraySize - 1, temp);

        return strings;
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {

        LinkedList<Integer> tempReversed = new LinkedList<>();

        for (int i = 0; i < numbers.size(); i++) {
            tempReversed.add(i, numbers.get(i));
        }

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, tempReversed.get(numbers.size()-1-i));
        }

        return numbers;
    }

    public static LinkedList<Integer> lessThanFive(LinkedList<Integer> numbers) {

        int less5 = 0;

        for (Integer num : numbers) {
            if (num < 5) {
                less5++;
            }
        }

        if (less5 == 0) {
            return null;
        }
        LinkedList<Integer> lessThan = new LinkedList<>();

        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }
        return lessThan;
    }
}
