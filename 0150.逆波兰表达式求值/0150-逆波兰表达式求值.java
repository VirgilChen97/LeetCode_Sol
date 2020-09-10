import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String now:tokens){
            if(now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                if(now.equals("+")){
                    stack.push(a + b);
                }else if(now.equals("-")){
                    stack.push(a - b);
                }else if(now.equals("*")){
                    stack.push(a * b);
                }else{
                    stack.push(a / b);
                }
            }else{
                stack.push(Integer.parseInt(now));
            }
        }
        return stack.pop();
    }
}