import java.util.*;

class Solution {
    Boolean[][][] mem;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        mem = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return verify(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    public boolean verify(char[] s1, int s1pos, char[] s2, int s2pos, char[] s3, int s3pos) {
        boolean res = false;
        if (s3.length == s3pos) {
            return true;
        } else {
            if (mem[s1pos][s2pos][s3pos] != null) {
                return mem[s1pos][s2pos][s3pos];
            } else {
                if (s1pos < s1.length && s1[s1pos] == s3[s3pos]) {
                    res |= verify(s1, s1pos + 1, s2, s2pos, s3, s3pos + 1);
                }
                if (s2pos < s2.length && s2[s2pos] == s3[s3pos]) {
                    res |= verify(s1, s1pos, s2, s2pos + 1, s3, s3pos + 1);
                }
                if (res) {
                    mem[s1pos][s2pos][s3pos] = true;
                } else {
                    mem[s1pos][s2pos][s3pos] = false;
                }
                return res;
            }
        }
    }
}