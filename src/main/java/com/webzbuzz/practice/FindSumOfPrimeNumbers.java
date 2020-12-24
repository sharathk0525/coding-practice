package com.webzbuzz.practice;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindSumOfPrimeNumbers {
    /*
    Take an array of numbers as input , select all prime numbers and return their sum. The following array of integers 1, 4, 5, 5, 7, 9, 13, 21, 30, 7, should return 37 (sum of 5, 5, 7, 7 and 13
     */

    public static void main(String[] args) {
        int[]  input = {1, 4, 5, 5, 7, 9, 13, 21, 30, 7};
        OptionalInt reduce =
                Arrays.stream(input).filter(value -> value !=1 && value !=2 && value!=3 && value%2 != 0 && value %3 != 0 ?
                        true :
                        false).reduce((left, right)  -> left + right);
        System.out.println(reduce.getAsInt());
    }
}
