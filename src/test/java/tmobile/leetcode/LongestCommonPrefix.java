package tmobile.leetcode;

import java.util.Arrays;
import java.util.List;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        //String [] input = {"flower","flow","floight"};
        //String [] input = {"a"};
//        String [] input = {"ab", "a"};
        String [] input = {"cir","car"};

        System.out.println(longestCommonPrefix.longestCommonPrefix(input));
        input[0].contains(input[1]);
    }

    public String longestCommonPrefix(String[] input) {
        if(input.length == 0 ){
            return "";
        }
        Arrays.sort(input);
        String result ="";
        String result1 ="";
        int count = 0;
        while(count < input[0].length()){
            if( input[0].length() < count+1){
                return input[0];
            }
            result = input[0].substring(0,count+1).toLowerCase();
            for (int i=1; i<input.length; i++){

                if(input[i].toLowerCase().contains(result)){
                  //  do nothing;
                }else{
                    return result1;
                }
                if(i == input.length-1){
                    result1 = input[0].substring(0,count+1);
                    count++;
                }

            }

        }


        return result1;
    }
}
