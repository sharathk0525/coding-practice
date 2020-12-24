package com.edabit.practice;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Given an unsorted array of unique integers, print all sequences
 * that increment by 1 and are longer than 1 element.

 * Do not worry about error handling.  The data array will always contain at
 * least one element and will not contain duplicates.

 * Example Array: 3, 12, 7, 9, 1, 2, 8, 11, 14
 * Example Output: [1, 2, 3], [7, 8, 9], [11,12]
 */


/*
/*
 * Given an unsorted array of integers containing duplicates, find all possible
 * sequences, using values no more times than they appear in the input.
 * Program must prefer creating the longest possible sequences from the input.
 *
 * Example Array: 8, 3, 4, 9, 5, 12, 4, 5, 6, 9
 * Example Output: [3, 4, 5, 6], [4, 5], [8, 9]
 *
 * Example Array: 8, 3, 4, 9, 5, 12, 4, 5, 6, 9, 1, 4, 5, 3, 2
 */


class PrintLongestSequence {
    static int[] data1 = {3, 12, 7, 9, 1, 2, 8, 11, 14};
    static int[] data = {8, 3, 4, 9, 5, 12, 4, 5, 6, 9};



    public static void main(String[] args) {
        //System.out.println(Arrays.toString(data));
        // Step 1 : sort array in ascending order
        // Step 2 : loop thru the array, if difference between (current_element) - (next_element) =1
        //store in result array

        Arrays.sort(data);
        System.out.println(Arrays.toString(data));


        List<int[]> ints = Arrays.asList(data);
        List<Integer> collect1 = Arrays.stream(data).boxed().collect(Collectors.toList());
        Map<int[], Long> collect = ints.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> collect2 = collect1.stream()
                                              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);

//        collect.forEach((ints1, aLong) -> System.out.println(Arrays.toString(ints1) +"  "+aLong));
        //collect2.forEach((ints1, aLong) -> System.out.println(ints1 +"  "+aLong));

        Set<Integer> result = new HashSet();
        for(int i=0; i<data.length-1; i++){
            if(data[i+1] - data[i] == 0){
                continue;
            }
            if(data[i+1] - data[i] == 1){
                result.add(data[i]);
                result.add(data[i+1]);

               /* if(collect2.containsKey(data[i])){
                    Long aLong = collect2.get(data[i]);
                    collect2.put(data[i], aLong-1);
                }*/







            }else{
                System.out.println(result);
                for (Map.Entry<Integer, Long> entry : collect2.entrySet()) {
                    if(result.contains(entry.getKey())){
                        collect2.put(entry.getKey(), entry.getValue()-1);
                    }
                }
                result.clear();
            }
        }
        collect2.forEach((ints1, aLong) -> System.out.println(ints1 +"  "+aLong));

    }
}
