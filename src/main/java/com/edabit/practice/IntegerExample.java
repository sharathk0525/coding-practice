package com.edabit.practice;

import java.util.stream.Stream;

public class IntegerExample {

    public static void main(String[] args) {
        System.out.println(Integer.max(1,2));
        int[] arr = new int[]{12, 13, 14};
        Stream<int[]> arr1 = Stream.of(arr);
    }
}
