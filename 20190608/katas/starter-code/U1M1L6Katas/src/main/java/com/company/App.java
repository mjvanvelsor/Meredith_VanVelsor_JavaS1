package com.company;

public class App {

    // Main Method -- Array Test
    public static void main(String[] args) {
        int[] testArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150};
        int[] answer = everyThird(testArray);
        System.out.println(everyThird(testArray));

        for (int h : answer) {
            System.out.println(h);
        }
    }

    //Total
    public static int total(int[] totalArr) {  // declare array in method, int return type, name method, declare parameter of int array and name
        int sum = 0;                           // set sum to 0
        for (int value : totalArr) {           // loop incrementally adds each element into the 'value'space
            sum += value;                      // tells value to hold the total sum as each element is added
        }
        return sum;                             // have to have a return to call in main method
    }

    //TotalOdd
    public static int totalOdd(int[] oddNums) {         // same as even, but for odd
        int total = 0;
        for (int i = 0; i < oddNums.length; i++) {
            if (i % 2 == 1) {
                total += oddNums[i];
            }
        }
        return total;
    }

    //TotalEven
    public static int totalEven(int[] evenNums) {         // declare method has int return type, set parameters of array called evenNums
        int total = 0;                                    // declare and assign a holding container for final solution, set to 0
        for (int i = 0; i < evenNums.length; i++) {       // for loop (initialization; termination; increment)
            if (i % 2 == 0) {                             // sets condition to IF an index location number is even (no remainder when divided by 2)
                total += evenNums[i];                     // THEN add the value of the number at that index to the 'total' until array is finished
            }
        }
        return total;                                     // print total value of the even index locations held in 'total'
    }

    // 2nd Largest Number
    public static int secondLargestNumber(int[] secondMax) {   // set up meth, int return type, array 'secondMax' parameter
        for (int i = 0; i < secondMax.length; i++) {           // for loop, set up counting incrementally to end at the full length of any array
            int max2;                                          // declare max2 as temporary holder
            for (int k = i + 1; k < secondMax.length; k++)       // set up SECOND counter to move incrementally with second index location

                if (secondMax[i] > secondMax[k]) {             // if condition if location i is greater than location k
                    max2 = secondMax[i];                       // store value of i in max2
                    secondMax[i] = secondMax[k];               // store value in location k inside of location i
                    secondMax[k] = max2;                       // then set max2 to value of location k
                }
        }
        return secondMax[secondMax.length - 2];                   // return the value of the 2nd largest number bc it will be the second to last location in the array.
    }

    // Swap First and Last
    public static String[] swapFirstAndLast(String[] swapArr) {
        String word1 = swapArr[0];
        String word2 = swapArr[swapArr.length - 1];

        String temp = word1;        // temp for first word

        word1 = word2;
        word2 = temp;

        swapArr[0] = word1;
        swapArr[swapArr.length - 1] = word2;
        return swapArr;
    }

    // Reverse
    public static int[] reverse(int[] originalArr) {
        ;
        int[] reversedArr = new int[originalArr.length];     //makes new array to put things in
        int indexNew = 0;                                    // keeps track of index or new array
        for (int i = originalArr.length - 1; i > -1; i--) {  //sets up reverse incrementing for transfer
            reversedArr[indexNew] = originalArr[i];         //transfers each element to new array
            indexNew++;                                     // increments to new element
        }
        return reversedArr;                                 //returns new array
    }

    // Concatenate String

    public static String concatenateString(String[] concatStr) {
        String strContainer = concatStr[0];             // sets place to hold value of current string
        for (int i = 1; i < concatStr.length; i++) {    // sets up incrementation to be less than strength length (termination)
            strContainer += concatStr[i];               // incrementally adds each new string from array to final string.
        }
        return strContainer;
    }

    // Every 3rd

    public static int[] everyThird(int[] oldArray) {

        int[] newArray = new int[oldArray.length / 3];          //makes new array to put things in

        if (oldArray.length < 3) {                              // condition for when old array doesn't have 3 numbers
            return null;
        } else {
            for (int i = 0; i < newArray.length; i++) {         // incrementally goes through old array
                newArray[i] = oldArray[i * 3 + 2];                  // adds every 3rd value to new array
            }
            return newArray;
        }
    }

    // Less than 5
    public static int[] lessThanFive(int[] inputArray) {

        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {         // incrementally goes through input array
            if (inputArray[i] < 5) {
                counter++;
            }
        }

        if (counter == 0) {
            return null;
        } else {
            int[] newArray = new int[counter];

            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] < 5) {
                    newArray[newArray.length - counter] = inputArray[i];  // need to start index at 0
                    counter--;
                }
            }

            return newArray;
        }
    }
}


//        int total = 0;
//                for (int i = 0; i < oddNums.length; i++) {
//        if (i % 2 == 1) {
//        total += oddNums[i];
//        }
//        }
//        return total;
//        }


