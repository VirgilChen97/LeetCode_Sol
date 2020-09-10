import java.util.*;

class Solution {
    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        helper(s, 0, "");
        return res;
    }

    public void helper(String s, int part, String curr) {
        if (s.length() == 0) {
            return;
        }
        if (part == 3) {
            if (s.length() <= 3 && !(s.length() > 1 && s.startsWith("0"))) {
                int num = Integer.parseInt(s);
                if (num < 256) {
                    res.add(curr + s);
                }
            }
        } else {
            for (int i = 1; i <= 3 && i < s.length(); i++) {
                String now = s.substring(0, i);
                int num = Integer.parseInt(now);
                if (num < 256 && !(i > 1 && now.startsWith("0"))) {
                    helper(s.substring(i), part + 1, curr + s.substring(0, i) + ".");
                }
                
            }
        }
    }
}