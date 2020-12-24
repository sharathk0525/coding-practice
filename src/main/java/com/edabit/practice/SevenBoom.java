package com.edabit.practice;

import java.util.Arrays;
import java.util.List;

/*
sevenBoom([1, 2, 3, 4, 5, 6, 7]) ➞ "Boom!"

sevenBoom([8, 6, 33, 100]) ➞ "there is no 7 in the array"

sevenBoom([2, 55, 60, 97, 86]) ➞ "Boom!"
 */
public class SevenBoom {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(8, 6, 33, 100);
        System.out.println(sevenBoom(input));
    }

    private static boolean sevenBoom(List<Integer> input) {
        return input.stream().anyMatch(integer -> integer ==7);
    }
}
