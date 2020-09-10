class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for(char now: S.toCharArray()){
            if(now=='#'){
                if(sb.length()!=0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(now);
            }
        }
        for(char now: T.toCharArray()){
            if(now=='#'){
                if(tb.length()!=0){
                    tb.deleteCharAt(tb.length() - 1);
                }
            }else{
                tb.append(now);
            }
        }
        return sb.toString().equals(tb.toString());
    }
}