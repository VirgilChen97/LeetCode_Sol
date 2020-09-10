import java.util.*;

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] counts = new int[256];
        for(char a:s.toCharArray()){
            counts[a]++;
        }

        boolean hasSingle = false;
        for(int count:counts){
            if((count & 1) != 0){
                if(hasSingle){
                    return false;
                }else{
                    hasSingle = true;
                }
            }
        }
        return true;
    }
}