package com.edabit.practice;

import java.util.List;
import java.util.stream.Collectors;

/*
Create a program that converts a phone number with letters to one with only numbers.

Number	Letter
0	none
1	none
2	ABC
3	DEF
4	GHI
5	JKL
6	MNO
7	PQRS
8	TUV
9	WXYZ
Examples
textToNum("123-647-EYES") ➞ "123-647-3937"

textToNum("(325)444-TEST") ➞ "(325)444-8378"

textToNum("653-TRY-THIS") ➞ "653-879-8447"

textToNum("435-224-7613") ➞ "435-224-7613"
 */
public class PhoneNumberWordDecoder {

    public static void main(String[] args) {
        textToNum("325-444-TEST");
    }

    private static void textToNum(String input) {
        String newInput = input.substring(8);
        List<Character> characterList = newInput.chars()
                                       .mapToObj(i -> (char) i)

                                       .collect(Collectors.toList());
        System.out.println(characterList.toString());

        mapCharactersToNumber(characterList);
    }

    private static void mapCharactersToNumber(List<Character> characterList) {

        for (Character character  : characterList) {

            switch (character){
                case 'A':
                case 'B' :
                case 'C' :
                    System.out.println("2");
                break;

                case 'D':
                case 'E' :
                case 'F' :
                    System.out.println("3");
                    break;

                case 'G':
                case 'H' :
                case 'I' :
                    System.out.println("4");
                    break;

                case 'J':
                case 'K' :
                case 'L' :
                    System.out.println("5");
                    break;

                case 'M':
                case 'N' :
                case 'O' :
                    System.out.println("6");
                    break;

                case 'P':
                case 'Q' :
                case 'R' :
                case 'S' :
                    System.out.println("7");
                    break;

                case 'T':
                case 'U' :
                case 'V' :
                    System.out.println("8");
                    break;

                case 'W':
                case 'X' :
                case 'Y' :
                case 'Z' :
                    System.out.println("9");
                    break;

            }

        }

    }
}
