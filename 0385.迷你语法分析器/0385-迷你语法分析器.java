import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        int sign = 1;
        int num = 0;
        boolean hasNum = false;
        Stack<NestedInteger> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ',') {
                if(hasNum){
                    stack.peek().add(new NestedInteger(num * sign));
                    sign = 1;
                    num = 0;
                    hasNum = false;
                }
            } else if (c == ']') {
                if (hasNum) {
                    stack.peek().add(new NestedInteger(num * sign));
                    sign = 1;
                    num = 0;
                    hasNum = false;
                }
                if (stack.size() > 1) {
                    NestedInteger list = stack.pop();
                    stack.peek().add(list);
                }
            } else if (c == '-') {
                sign = -1;
            } else {
                num = num * 10 + c - '0';
                hasNum = true;
            }
        }
        if (hasNum && stack.isEmpty()) {
            return new NestedInteger(num * sign);
        } else {
            return stack.pop();
        }
    }
}