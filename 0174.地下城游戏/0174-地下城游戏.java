class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1 - dungeon[dungeon.length - 1][dungeon[0].length - 1], 1);
        
        for(int i = dungeon.length - 1; i >=0; i--){
            for(int j = dungeon[0].length - 1; j >= 0; j--){
                if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
                    continue;
                }else if(i == dungeon.length - 1){
                    dp[i][j] = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                }else if(j == dungeon[0].length - 1){
                    dp[i][j] = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                }else{
                    dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
                }
            }
        }
        return dp[0][0];
    }
}