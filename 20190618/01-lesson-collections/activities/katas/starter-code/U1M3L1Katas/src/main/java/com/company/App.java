package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static ArrayList<String> swapFirstAndLast(ArrayList<String> strings) {

        int arraySize = strings.size();

        String temp = strings.get(0);
        strings.set(0, strings.get(arraySize - 1));
        strings.set(arraySize - 1, temp);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {

        List<Integer> tempReversed = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            tempReversed.add(i, numbers.get(i));
            }

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, tempReversed.get(numbers.size()-1-i));
        }

        return numbers;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {

        int less5 = 0;

        for (Integer num : numbers) {
            if (num < 5) {
                less5++;
            }
        }

            if (less5 == 0) {
                return null;
            }
        List<Integer> lessThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }
        return lessThan;
    }

//    //challenge
//    public static int[][] splitAtFive(int[] numbers) {
//        int numLessThanFive = 0;
//        int numMoreThanFive = 0;
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            } else {
//                numMoreThanFive++;
//            }
//        }
//
//        int[] lessThan = new int[numLessThanFive];
//        int[] moreThan = new int[numMoreThanFive];
//
//
//        for(int num : numbers) {
//
//            // subtracting numLessThanFive from length then decrementing numLessThanFive
//            // allows us to go from 0 to length - 1 in order without additional variables
//            // same with numMoreThanFive
//            if ( num < 5 ) {
//                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            } else {
//                moreThan[moreThan.length - numMoreThanFive] = num;
//                numMoreThanFive--;
//            }
//        }
//
//        return new int[][] { lessThan, moreThan };
//    }
//

    public static List<List<String>> evensAndOdds(List<String> strings) {

        List<String> odds = new ArrayList<>();
        List<String> evens = new ArrayList<>();
        List<List<String>> newArrList = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {
            if (i % 2 == 0){
            evens.add(strings.get(i));
        } else {
            odds.add(strings.get(i));
        }
        }

        newArrList.add(0,evens);
        newArrList.add(1,odds);

        return newArrList;
    }
}
