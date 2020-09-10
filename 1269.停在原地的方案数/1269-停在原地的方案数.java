class Solution {
    public int numWays(int steps, int arrLen) {
        int len = Math.min(arrLen, steps);
        int[][] dp = new int[steps+1][len];
        dp[0][0] = 1;
        for(int i = 1; i < len; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < steps + 1; i++){
            for(int j = 0; j < len; j++){
                dp[i][j] = dp[i-1][j] % 1000000007;
                if(j-1 >= 0){
                    dp[i][j] += dp[i-1][j-1] % 1000000007;
                    dp[i][j] = dp[i][j] % 1000000007;
                }
                if(j + 1 < len){
                    dp[i][j] += dp[i-1][j+1] % 1000000007;
                    dp[i][j] = dp[i][j] % 1000000007;
                }
            }
        }
        return dp[steps][0];
    }
}