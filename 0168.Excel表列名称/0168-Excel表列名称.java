class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n>0) {
            n--;
            String digits = (char) (n % 26 + 'A') + "";
            res = digits + res;
            n = n / 26;
        }
        return res;
    }
}