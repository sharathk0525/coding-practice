package com.edabit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
identicalFilter(["aaaaaa", "bc", "d", "eeee", "xyz"])
➞ ["aaaaaa", "d", "eeee"]

identicalFilter(["88", "999", "22", "545", "133"])
➞ ["88", "999", "22"]

identicalFilter(["xxxxo", "oxo", "xox", "ooxxoo", "oxo"])
➞ []
 */
public class FilterRepeatingCharacterStrings {



    public static void main(String[] args) {
        String[]     input      = { "aaaaaa", "bc", "d", "eeee", "xyz" };
        List<String>         stringList = Arrays.asList(input);

        Map<String, Long> stringLongMap = new HashMap<>();
       for (String s : stringList) {
           stringLongMap = s.chars()
                                         .mapToObj(i -> (char) i)
                                         .collect(Collectors.groupingBy(Objects::toString, Collectors.counting()));
        }

        List<String>         results = new ArrayList<>();
        for (String s : stringList) {
            if(s.length() == 1){
                results.add(s);
                continue;
            }
            char[] charArray = s.toCharArray();

            Map<Character, Integer> stringLongMap1 = new HashMap<>();
            for (char c : charArray) {
                int counter =0;
                if(stringLongMap1.containsKey(c)){
                    counter = stringLongMap1.get(c);
                    stringLongMap1.put(c, counter+1);
                    counter = counter+1;
                }else{
                    stringLongMap1.put(c, 1);
                }

               // Integer counter = stringLongMap1.get(c);
                if(counter ==2){
                    results.add(s);
                    break;
                }


            }
        }

        System.out.println(results);


    }


}
