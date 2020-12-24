package com.edabit.practice;

import java.util.List;
import java.util.stream.Collectors;

public class ToConvertCharactersToUpperOrLowerCase {

    public static void main(String[] args) {
        String s = "Sharath7";
        String result ="";
        StringBuffer result1 = new StringBuffer("");
        List<Character> characterList = s.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
        System.out.println(characterList);

       /* s.chars().filter(character -> Character.isAlphabetic(character))
                 .filter(value -> Character.isLowerCase()).*/
        for (int i = 0; i < characterList.size(); i++) {
            Character currentCharacter = characterList.get(i);
            if(Character.isAlphabetic((currentCharacter))){
                if(Character.isLowerCase(currentCharacter)){
                     result1.append(Character.toString(Character.toUpperCase(currentCharacter)));
                }else if(Character.isUpperCase(currentCharacter)){
                    result1.append(Character.toString(Character.toLowerCase(currentCharacter)));
                }
            }else {
                result1.append(Character.toString(currentCharacter));
            }
        }
        result = result1.toString();
        System.out.println(result1);
    }
}
