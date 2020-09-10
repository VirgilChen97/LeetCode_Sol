class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = (numRows - 1)*2;
        int firstStep = step;
        for (int i = 0; i < numRows; i++) {
            int secondStep = step - firstStep;
            int j = i;
            if(j < s.length()){
                sb.append(s.charAt(j));
            }
            while(j < s.length()){
                j+=firstStep;
                if(j<s.length() && firstStep!=0){
                    sb.append(s.charAt(j));
                }
                j+=secondStep;
                if(j < s.length() && secondStep!=0){
                    sb.append(s.charAt(j));
                }
            }
            firstStep -= 2;
        }
        return sb.toString();
    }
}