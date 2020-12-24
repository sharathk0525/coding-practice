package com.webzbuzz.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseStringExtractValues {

    public static void main(String[] args) {
        String input = "11 ,  34,,   45 ,,  88, 99||22";
        StringBuffer result = new StringBuffer();
        Stream<Character> characterStream = input.chars().mapToObj(value -> (char) value);
        Stream<Character> sorted = characterStream.filter(character -> Character.isDigit(character))
                                                  .sorted(Comparator.reverseOrder());
        //System.out.println(sorted.collect(Collectors.toList()));
        sorted.forEach(character -> result.append(character));
        System.out.println(result.toString());
    }
}
