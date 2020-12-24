package com.edabit.practice;

/*
almostPalindrome("abcdcbg") ➞ true
// Transformed to "abcdcba" by changing "g" to "a".

almostPalindrome("abccia") ➞ true
// Transformed to "abccba" by changing "i" to "b".

almostPalindrome("abcdaaa") ➞ false
// Can't be transformed to a palindrome in exactly 1 turn.

almostPalindrome("1234312") ➞ false
 */
public class AlmostPalindrome {

    public static void main(String[] args) {
        System.out.println(almostPalindrome("1234312"));
    }

    private static boolean almostPalindrome(String input) {
        //if(input.length()%2 == 0) return false;

        char[] charArray = input.toCharArray();
        int counter=0;
        for (int i = 0; i < charArray.length/2; i++) {
            if(charArray[i] == charArray[charArray.length-1-i]){

            }else{
                counter++;
            }
        }
        if(counter ==1){
            return true;
        }
        return false;
    }
}
