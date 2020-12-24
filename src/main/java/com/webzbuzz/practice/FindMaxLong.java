package com.webzbuzz.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMaxLong {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("77", "332", null, "10", "500", "");
        List<String> collect1 = strings.stream().filter(str -> str != null && !str.isEmpty()).collect(Collectors.toList());
        List<Long>   collect2 = collect1.stream().map(e -> Long.valueOf(e)).collect(Collectors.toList());
        collect2.stream().sorted();
        //System.out.println(collect2.get(collect2.size()-1));

        List<Integer> collect4 = Stream.of(1, 2, 3, 4, 5, 6, 7)
                                      .filter(not(c -> c % 2 == 0)).collect(Collectors.toList());
        //System.out.println(collect4);

        Optional<Long> max = strings.stream()
                                   .filter(s -> s != null && s.length() > 0)
                                   .map(s -> new Long(s.trim()))
                                   .max((a, b) -> a < b ? -1 : 0);
        System.out.println(max.get());
    }

    public static <R> Predicate<R> not(Predicate<R> predicate) {
        return predicate.negate();
    }
}
