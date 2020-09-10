class Solution {
    public int checkRecord(int n) {
        long opt[][][] = new long[2][3][n+1];
        opt[0][1][1] = 1;
        opt[1][0][1] = 1;
        opt[0][0][1] = 1;
        long mod = 1000000007L;

        for(int i = 2; i <= n; i++){
            opt[0][0][i] = (opt[0][0][i-1] + opt[0][1][i-1] + opt[0][2][i-1]) % mod;
            opt[1][0][i] = (opt[0][0][i-1] + opt[0][1][i-1] + opt[0][2][i-1] + opt[1][0][i-1] + opt[1][1][i-1] + opt[1][2][i-1]) % mod;
            opt[0][1][i] = opt[0][0][i-1];
            opt[0][2][i] = opt[0][1][i-1];
            opt[1][1][i] = opt[1][0][i-1];
            opt[1][2][i] = opt[1][1][i-1];
        }

        return (int)((opt[0][0][n] + opt[0][1][n] + opt[0][2][n] + opt[1][0][n] + opt[1][1][n] + opt[1][2][n]) % mod);
    }
}