import java.util.*;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (!check(s1, s2)) {
            return false;
        }

        boolean res = false;

        for (int i = 1; i < s1.length(); i++) {
            res |= isScramble(s1.substring(0, i), s2.substring(0, i)) 
                    && isScramble(s1.substring(i), s2.substring(i));
            if (res)
                return res;
            res |= isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i));
            if (res)
                return res;
        }

        return res;
    }

    public boolean check(String s1, String s2) {
        int[] count = new int[256];

        for (char a : s1.toCharArray()) {
            count[a]++;
        }
        for (char a : s2.toCharArray()) {
            if (count[a] == 0) {
                return false;
            } else {
                count[a]--;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}