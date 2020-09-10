class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int weight = 0;
        for(int i = s.length()-1; i>=0; i--){
            int digits = s.charAt(i) - 'A' + 1;
            res += digits * Math.pow(26, weight);
            weight++;
        }
        return res;
    }
}