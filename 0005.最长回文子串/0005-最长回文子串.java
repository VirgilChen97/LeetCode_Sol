import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        int centers = s.length()*2 - 1;
        int max = 0;
        int position = 0;
        for (int i = 0; i < centers; i++) {
            int start, end, count;
            if(i % 2 == 0){
                start = i/2;
                end = i/2;
                count = -1;
            }else{
                start = (i-1) / 2;
                end = (i+1) / 2;
                count = 0;
            }
            while(start >= 0 && end < s.length()){
                if(s.charAt(start) == s.charAt(end)){
                    count+=2;
                }else{
                    break;
                }
                start --;
                end ++;
            }
            if(count > max){
                max = count;
                position = end;
            }
        }
        return s.substring(position - max, position);
    }
}