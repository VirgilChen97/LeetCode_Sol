import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0,j = 0;
        char[] arr = s.toCharArray();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            if(map.containsKey(arr[j])){
                i = Math.max(map.get(arr[j]), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(arr[j],j + 1);
            j++;
        }
        return max;
    }
}