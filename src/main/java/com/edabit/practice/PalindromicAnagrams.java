package com.edabit.practice;

/*
isPalindromePossible("rearcac") ➞ true
// You can make "racecar"

isPalindromePossible("suhbeusheff") ➞ true
// You can make "sfuehbheufs" (not a real word but still a palindrome)

isPalindromePossible("palindrome") ➞ false
// It's impossible

Given a word, create a function which returns whether or not it's possible to
create a palindrome by rearranging the letters
in the word.
 */
public class PalindromicAnagrams {

    private static boolean isPalindromePossible(String input) {
        char[] toCharArray = input.toCharArray();
        int middle      = input.length() / 2;
        for (int i = 0; i < middle; i++) {
            char c = input.charAt(i);
            boolean contains = input.substring(middle).contains(Character.toString(c));
            System.out.println(contains);
            if(contains == false){
                //this character should be in middle
                toCharArray[i] = toCharArray[middle];
                toCharArray[middle] = c;
                input = String.valueOf(toCharArray);

            }
        }
        System.out.println(toCharArray);

        for (int i = 0; i < middle; i++) {
            if(toCharArray[i] != toCharArray[toCharArray.length-i-1]){

                char c = input.charAt(i);
                boolean contains = input.substring(i+1).contains(Character.toString(c));
                if(contains == true){
                    // swap chars
                    toCharArray[i] = toCharArray[toCharArray.length-i-1];
                    toCharArray[toCharArray.length-i-1] = c;
                    System.out.println(toCharArray);

                }
            }
        }
        System.out.println(toCharArray);

        return false;
    }

    public static void main(String[] args) {
        System.out.println("HI");
         isPalindromePossible("rearcac");
         //isPalindromePossible("earcrac");
        //System.out.println("r".contains("earcac"));
        //System.out.println("earcac".contains("r"));
    }
}
