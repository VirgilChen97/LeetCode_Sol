class Solution {
    int mod = (int)1e9 + 7;

    public int findPaths(int m, int n, int N, int i, int j) {
        if(N == 0){
            return 0;
        }
        
        int dp[][][] = new int[m][n][N];
        int directions[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;

        dp[i][j][0] = 1;
        for (int k = 0; k < N; k++) {
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for(int l = 0; l < 4; l++){
                        int prevRow = row + directions[l][0];
                        int prevCol = col + directions[l][1];
                        if(prevRow >= 0 && prevRow < m && prevCol >=0 && prevCol < n && k - 1 >= 0){
                            dp[row][col][k] = (dp[row][col][k] + dp[prevRow][prevCol][k-1] % mod) % mod;
                        }
                    }

                    for(int l = 0; l < 4; l++){
                        int nextRow = row + directions[l][0];
                        int nextCol = col + directions[l][1];
                        if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n){
                            count = (count % mod + dp[row][col][k] % mod )% mod;
                        }
                    }
                }
            }
        }
        return count;
    }
}