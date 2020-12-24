package com.edabit.practice;

/*
sum([1, 2, 3, 4]) ➞ 10

sum([1, 2]) ➞ 3

sum([1]) ➞ 1

sum([]) ➞ 0
 */
public class RecursionArraySum {
    public static void main(String[] args) {
        int input[] = {};
        int sum=0;
        for (int i : input) {
            sum = sum+i;
        }
        System.out.println("Sum "+sum);
    }
}
