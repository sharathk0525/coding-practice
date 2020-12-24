package com.edabit.practice;

import java.util.ArrayList;
import java.util.List;

/*
primeNumbers(10) ➞ 4
// 2, 3, 5 and 7

primeNumbers(20) ➞ 8
// 2, 3, 5, 7, 11, 13, 17 and 19

primeNumbers(30) ➞ 10
// 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29
 */
public class HowManyPrimeNumbersAreThere {
    public static void main(String[] args) {
        primeNumbers(10);
    }

    private static void primeNumbers(int input) {
        if(input <2){
            System.out.println(input+" should be >2");
            return;
        }
        List<Integer> resultList = new ArrayList<>();
        if(input ==2){
            resultList.add(input);
            System.out.println(resultList +"    size "+resultList.size());
            return;
        }

        for(int i=2; i<=input; i++){
            if(isPrimeNumber(i)){
                resultList.add(i);
            }
        }
        System.out.println(resultList +"    size "+resultList.size());

    }

    private static boolean isPrimeNumber(int i) {
        if(i==2 || i==3){
            return true;
        }
        if(i%2 == 0 || i%3==0 )
            return false;
        else
            return true;

    }
}
