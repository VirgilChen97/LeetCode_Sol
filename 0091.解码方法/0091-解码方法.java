class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0) != '0' ? 1 : 0;
        dp[0][1] = 0;

        if (s.length() < 2) {
            return dp[0][0] + dp[0][1];
        }

        dp[1][0] = s.charAt(1) != '0' ? dp[0][0] + dp[0][1] : 0;
        dp[1][1] = check(s.charAt(0), s.charAt(1)) ? 1 : 0;

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            }
            if (check(s.charAt(i-1), s.charAt(i))) {
                dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            }
        }
        return dp[s.length() - 1][0] + dp[s.length() - 1][1];
    }

    public boolean check(char first, char second){
        if(first == '1'){
            return true;
        }
        if(first == '2' && second <= '6'){
            return true;
        }
        return false;
    }
}