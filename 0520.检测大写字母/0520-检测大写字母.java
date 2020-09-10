import java.util.*;
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstLetter = false;
        boolean secondLetter = false;
        if(word.length()<=1){
            return true;
        }
        if(isUpperCase(word.charAt(0))){
            firstLetter = true;
        }
        if(isUpperCase(word.charAt(1))){
            secondLetter = true;
        }
        if(word.length() <= 2){
            if(firstLetter || !firstLetter && !secondLetter){
                return true;
            }
        }

        if(!secondLetter){
            for (int i = 2; i < word.length(); i++) {
                if(isUpperCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }else if(firstLetter && secondLetter){
            for (int i = 2; i < word.length(); i++) {
                if(!isUpperCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean isUpperCase(char c){
        if('a' <= c && c <= 'z'){
            return false;
        }else{
            return true;
        }
    }
}