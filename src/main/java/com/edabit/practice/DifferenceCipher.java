package com.edabit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DifferenceCipher {
    /*
    Difference Cipher
It's time to send and receive secret messages.

Create two functions that take a string and an array and returns a coded or decoded message.

The first letter of the string, or the first element of the array represents the Character Code of that letter. The next elements are the differences between the characters: e.g. A +3 --> C or z -1 --> y.

Examples
encrypt("Hello") ➞ [72, 29, 7, 0, 3]
// H = 72, the difference between the H and e is 29 (upper- and lowercase).
// The difference between the two l's is obviously 0.

decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) ➞ "Hi there!"

encrypt("Sunshine") ➞ [83, 34, -7, 5, -11, 1, 5, -9]
Notes
The input of the encrypt function will always be a string.
The input of the decrypt function will always be an array with numbers.
     */
    public static void main(String[] args) {
        //encrypt("Hello");
        List<Integer> inputList = Arrays.asList(72, 33, -73, 84, -12, -3, 13, -13, -68);
        decrypt(inputList);
    }

    private static void decrypt(List<Integer> inputList) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(inputList.get(0));
        for (int i = 1; i < inputList.size(); i++) {
            resultList.add(inputList.get(i)+inputList.get(i-1));


        }
        System.out.println(resultList);
        List<char[]> collect =
                resultList.stream().map(integer -> Character.toChars((int) Math.sqrt(Math.pow(integer, 2)))).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void encrypt(String input) {
        List<Integer> integerList = input.chars().mapToObj(value -> value).collect(Collectors.toList());
        System.out.println(integerList);

        List<Integer> resultList = new ArrayList<>();
        resultList.add(integerList.get(0));
        for (int i = 1; i < integerList.size(); i++) {
            resultList.add(integerList.get(i)-integerList.get(i-1));


        }
        System.out.println(resultList);
    }
}
