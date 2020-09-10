class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }

        Stack<Character> st = new Stack<>();

        for(char a : s.toCharArray()){
            if(a == '('){
                st.push(')');
            }else if(a == '['){
                st.push(']');
            }else if(a == '{'){
                st.push('}');
            }else{
                if(st.empty()){
                    return false;
                }
                if(st.pop()!=a){
                    return false;
                }
            }
        }
        
        if(st.empty()) {
            return true;
        }else {
            return false;
        }
    }
}