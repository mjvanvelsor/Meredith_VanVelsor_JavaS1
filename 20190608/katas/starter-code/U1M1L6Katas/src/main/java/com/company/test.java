package com.company;

public class test {

    public static int[] reverse(int[] reversedArr) {

        for (int i = reversedArr.length - 1; i >= 0; i--) {
            i--;
        }
        return reversedArr;
    }

    public static void main(String[] args) {
        int[] arr2 = {10, 20, 30, 40};
        System.out.println(reverse(arr2));
    }
}
