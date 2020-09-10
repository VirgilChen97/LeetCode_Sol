import java.util.*;

class Solution {
    public int maxVowels(String s, int k) {
        int curr = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < k; i++){
            if(judge(arr[i])){
                curr++;
            }
        }
        int max = curr;

        for(int i = k; i < s.length(); i++){
            if(judge(arr[i - k])){
                curr --;
            }
            if(judge(arr[i])){
                curr ++;
            }
            if(curr > max){
                max = curr;
            }
        }
        return max;
    }

    public boolean judge(char a){
        char[] target = new char[]{'a','e','i','o','u'};
        for(char now:target){
            if(a == now){
                return true;
            }
        }
        return false;
    }
}