import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        for (char a : s.toCharArray()) {
            if (a - 'a' < 0) {
                arr[a - 'A' + 26]++;
            } else {
                arr[a - 'a']++;
            }
        }
        int longestOdd = 0;
        int evenLength = 0;
        for (int i = 0; i < 52; i++) {
            int count = arr[i];
            if ((count & 1) == 0) {
                evenLength += count;
            } else {
                if (longestOdd < count) {
                    if (longestOdd != 0) {
                        evenLength += longestOdd - 1;
                    }
                    longestOdd = count;
                } else {
                    evenLength += count - 1;
                }
            }
        }
        return longestOdd + evenLength;
    }
}