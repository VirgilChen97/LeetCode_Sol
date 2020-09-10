class Solution {
    int pos = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        for(;pos < s.length(); pos++){
            if('0' < s.charAt(pos) && s.charAt(pos) < '9'){
                int k = 0;
                while(s.charAt(pos) != '['){
                    k = k * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                pos++;
                String sub = decodeString(s);
                for(int i = 0; i < k; i++){
                    res.append(sub);
                }
            }else if(s.charAt(pos) == ']'){
                return res.toString();
            }else{
                res.append(s.charAt(pos));
            }
        }
        return res.toString();
    }
}