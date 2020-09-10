import java.util.*;
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                count++;
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    res.insert(stack.pop() - count + 1, "(");
                    res.append(")");
                    count-=1;
                }else{
                    count++;
                }
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}