import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for(int i = 0; i < A[0].length; i++){
            dp[0][i] = A[0][i];
        }

        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                int min = Integer.MAX_VALUE;
                if(j > 0){
                    min = Math.min(min, dp[i-1][j-1]);
                }
                if(j < A[0].length - 1){
                    min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = Math.min(min, dp[i-1][j]) + A[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A[0].length; i++){
            min = Math.min(dp[A.length - 1][i], min);
        }
        return min;

    }
}