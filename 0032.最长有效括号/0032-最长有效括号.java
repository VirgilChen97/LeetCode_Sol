import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        boolean mark[] = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()){
                    mark[i] = true;
                }else{
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            mark[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (mark[i]) {
                curr = 0;
                continue;
            }
            curr++;
            max = Math.max(max, curr);
        }

        return max;
    }
}