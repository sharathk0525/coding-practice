package com.edabit.practice;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo3 {
    public static void main(String[] args) {
        List<Integer> list2 = Arrays.asList(5, 6, 7,8);
        int           res   = list2.parallelStream().reduce(2, (s1, s2) -> s1 + s2, (p, q) -> p * q);
        System.out.println(res);
    }
}