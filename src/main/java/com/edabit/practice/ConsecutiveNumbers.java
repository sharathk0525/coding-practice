package com.edabit.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConsecutiveNumbers {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(5, 1, 4, 3, 2).stream().sorted().collect(Collectors.toList());
        List<Integer> integerList1 =
                (List<Integer>) integerList.stream().filter(i -> Collections.frequency(integerList, i) <= 1)
                                                                .collect(Collectors.toList());

        for (int i = 1; i < integerList1.size(); i++) {

            int previous = integerList1.get(i-1);
            int current = integerList1.get(i);

            if(previous+1 == current || current > previous+1){
                continue;
            }else{

                System.out.println(false);
                break;
            }

        }



    }
}
