import java.util.*;

class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> stack = new Stack<>();
        for(char a:s.toCharArray()){
            if(a == '#'){
                int ascii = stack.pop() - 'a' + 1;
                ascii += (stack.pop() - 'a' + 1) * 10;
                stack.push((char)(ascii + 'a' - 1));
            }else{
                stack.push((char)(a - '1' + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}