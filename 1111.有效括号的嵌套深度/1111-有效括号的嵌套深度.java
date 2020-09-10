import java.util.*;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[seq.length()];
        char a[] = seq.toCharArray();

        for (int i = 0; i < seq.length(); i++) {
            if (a[i] == '(') {
                stack.push(i);
            } else {
                if (stack.size() % 2 == 0) {
                    res[stack.pop()] = 1;
                    res[i] = 1;
                } else {
                    res[stack.pop()] = 0;
                    res[i] = 0;
                }
            }
        }
        return res;
    }
}