package com.webzbuzz.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildBigNumber {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("77", "332", null, "10", "500");
        StringBuffer result = new StringBuffer();
        String reduce = strings.stream().filter(s -> s != null && !s.isEmpty()).map(e -> Long.valueOf(e))
                               .sorted(Comparator.reverseOrder()).map(aLong -> aLong + "")
                               .reduce("", (s, s2) -> s + s2);

        System.out.println(reduce);
    }
}
