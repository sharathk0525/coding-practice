package com.edabit.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
String Incrementer
Write a function which increments a string to create a new string.

If the string ends with a number, the number should be incremented by 1.
If the string doesn't end with a number, 1 should be added to the new string.
If the number has leading zeros, the amount of digits should be considered.

incrementString("foo") ➞ "foo1"

incrementString("foobar0009") ➞ "foobar0010"

incrementString("foo099") ➞ "foo100"
 */
public class StringIncrementer {
    public static void main(String[] args) {
        String input = "foobar";
        incrementString(input);
    }

    private static void incrementString(String input) {
        if(!input.matches(".*\\d.*")){
            System.out.println(input+1);
            return;
        }
        // \u000d System.out.println("GeeksForGeeks");
        List<Character> characterList = input.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
        System.out.println(characterList);
        StringBuffer result = new StringBuffer();




        int leadingZerosCounter =0;
        for (int i =0 ; i<characterList.size(); i++) {
            Character currentCharacter = characterList.get(i);
            if(Character.isDigit(currentCharacter)){
                result.append(Character.toString(currentCharacter));
                if(leadingZerosCounter ==0)
                leadingZerosCounter = i;
            }

        }

        System.out.println(result.toString());
       int a = Integer.parseInt(result.toString())+1;
        System.out.println(a);

        String a1 = String.valueOf(a);
        if(a1.length() != result.length()){
            leadingZerosCounter = leadingZerosCounter+1;
        }

        System.out.println(input.substring(0,leadingZerosCounter)+a1);

    }
}
