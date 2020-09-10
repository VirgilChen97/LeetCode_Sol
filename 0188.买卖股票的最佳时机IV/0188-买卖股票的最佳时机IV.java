import java.util.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k/2 > prices.length){
            return maxKInf(k, prices);
        }else{
            return maxK(k, prices);
        }
    }

    public int maxKInf(int k, int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    public int maxK(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[i];
                    continue;
                }
                if(j == 0){
                    dp[i][0][0] = 0;
                    dp[i][0][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[dp.length - 1][k][0];
    }
}