package com.webzbuzz.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortCharactersInString {

    public static void main(String[] args) {
        String input = "zabcxdef12";
        StringBuffer result = new StringBuffer();
        IntStream chars = input.chars().sorted();
       // System.out.println(Arrays.toString(chars.toArray()));

        List<char[]>   chars1 = Collections.singletonList(input.toCharArray());
        Stream<char[]> sorted = chars1.stream().sorted();
        //System.out.println(Arrays.toString(sorted.toArray()));

        input.chars().boxed().sorted(Comparator.reverseOrder()).forEach(integer -> result.append((char) integer.byteValue()));

        System.out.println(result.toString());
    }
}
