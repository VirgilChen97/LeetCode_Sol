class Solution {
    public int minFallingPathSum(int[][] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i = 1; i < len; i++){
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                if(dp[i-1][j] <= min){
                    secondMin = min;
                    min = dp[i-1][j];
                }else if(dp[i-1][j] <= secondMin){
                    secondMin = dp[i-1][j];
                }
            }

            for(int j = 0; j < len; j++){
                if(dp[i-1][j] != min){
                    dp[i][j] = arr[i][j] + min; 
                }else{
                    dp[i][j] = arr[i][j] + secondMin; 
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            min = Math.min(dp[len-1][i], min);
        }

        return min;
    }
}