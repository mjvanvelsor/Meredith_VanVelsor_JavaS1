package com.trilogyed;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        int[] givenArr = {1, 2, 3, 4, 5};               // declaring the given index
        int[] equalLengthArr = new int[5];              // making new array of equal length to hold reversed values
        int tempIndex = 0;                              // temp holding place for each value

        for (int i = givenArr.length - 1; i >= 0; i--) {
            equalLengthArr[tempIndex] = givenArr[i];
            tempIndex++;
        }
        /*  Line 9 sets up reverse incrementing; i starts at index 4 (length = 5-1), terminates at 0 index,
            i-- sets the direction going downwards. Line 10 sets decrementing value of current array (5, 4, 3, 2, 1) to the
            correct (incrementing) location on the new array (0, 1, 2, 3, 4) respectively. tempIndex++ ensures temporary
            value is held for new array.
         */

        for (int i = 0; i < equalLengthArr.length; i++){        // loop prints incrementing values of the new array
            System.out.println(equalLengthArr[i]);              // but not the array itself
        }
    }
}
