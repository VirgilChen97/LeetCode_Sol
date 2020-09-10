import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; i - j >= 0 && i + j < arr.length; j++){
                if(arr[i-j] == arr[i+j]){
                    count++;
                }else{
                    break;
                }
            }
        }
        for(int i = 0; i < arr.length-1; i++){
            int l = i;
            int r = i + 1;
            while(l >= 0 && r < arr.length){
                if(arr[l] == arr[r]){
                    count ++;
                    l--;
                    r++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}