package com.webzbuzz.practice;

public class ComputeFactorial {
    static int result=1;
    public static void main(String[] args) {
        String input = "5";
        System.out.println(factorial(Integer.parseInt(input)));

    }

    private static int factorial(int input){
        if(input ==0){
            return 0;
        }
        if(input == 1){
            return result;
        }

        result = result * input;
        return factorial(input-1);

    }
}
