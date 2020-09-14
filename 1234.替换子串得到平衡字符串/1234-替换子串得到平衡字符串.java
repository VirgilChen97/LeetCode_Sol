import java.util.*;

class Solution {
    public int balancedString(String s) {
        int min = s.length();
        int[] count = new int[4];
        int[] find = new int[256];
        find['Q'] = 0;
        find['W'] = 1;
        find['E'] = 2;
        find['R'] = 3;

        for (char a : s.toCharArray()) {
            count[find[a]]++;
        }

        int l = 0;
        int r = 0;
        while (r <= s.length() && l < s.length()) {
            if (!check(count, s.length() / 4)) {
                if (r < s.length()) {
                    count[find[s.charAt(r)]]--;
                }
                r++;
            } else {
                min = Math.min(min, r - l);
                count[find[s.charAt(l)]]++;
                l++;
            }
        }

        if (check(count, s.length() / 4)) {
            min = Math.min(min, r - l);
        }

        return min;
    }

    public boolean check(int[] arr, int len) {
        for (int count : arr) {
            if (count > len) {
                return false;
            }
        }
        return true;
    }
}