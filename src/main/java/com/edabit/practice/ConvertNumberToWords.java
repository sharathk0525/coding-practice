package com.edabit.practice;

import java.util.StringJoiner;

public class ConvertNumberToWords {

    public static void main(String[] args) {
        int givenNumber = 832;

        String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tenThruNineteen = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                    "eighteen",
                                    "nineteen"};
        String[] tens = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] threeOrMoreDigits = {"units", "tens", "hundred", "thousand", "ten thousand", "lakh", "ten lakhs", "crore"};

        System.out.println(String.valueOf(givenNumber).length());
        String convertedString = String.valueOf(givenNumber);

        StringJoiner result = new StringJoiner(" ");
        int          length = convertedString.length();



        char[] toCharArray = convertedString.toCharArray();

        for (int i = 0; i < toCharArray.length; i++) {
            int c = Character.getNumericValue(toCharArray[i]);
            result.add(units[c]);

            if(length >=3){
                result.add(threeOrMoreDigits[length-1]);
            }
            System.out.println(result);

        }
    }
}
