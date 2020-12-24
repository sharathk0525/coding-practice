package com.edabit.practice;

/*
arrayOfMultiples(7, 5) ➞ [7, 14, 21, 28, 35]

arrayOfMultiples(12, 10) ➞ [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]

arrayOfMultiples(17, 6) ➞ [17, 34, 51, 68, 85, 102]
 */
public class ArrayOfMultiples {


    public static void main(String[] args) {

        arrayOfMultiples(7, 5);
    }

    private static void arrayOfMultiples(int num, int length) {
        int counter=1;
        while(counter <= length){
            System.out.print(num*counter+", ");
            counter++;
        }

    }
}
