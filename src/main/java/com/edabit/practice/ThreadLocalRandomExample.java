package com.edabit.practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ThreadLocalRandomExample {
    public static void main(String[] args) {
        System.out.println("Hi");
   ThreadLocalRandom.current()
                                      .ints(100, 1000)
                                      .limit(1000)
                                      .forEach(x -> System.out.println(x));
    }
}
