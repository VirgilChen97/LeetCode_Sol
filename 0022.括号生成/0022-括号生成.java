import java.util.*;

class Solution {
    Stack<Integer> stack;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        stack = new Stack<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        helper(n, n, "");
        return res;
    }

    public void helper(int left, int right, String now) {
        if (left == 0 && right == 0) {
            res.add(now.toString());
            return;
        }
        if (left != 0) {
            stack.push(1);
            helper(left - 1, right, now + "(");
            stack.pop();
        }
        if (right != 0) {
            if (stack.isEmpty()) {
                return;
            } else {
                stack.pop();
                helper(left, right - 1, now + ")");
                stack.push(1);
            }
        }
    }
}