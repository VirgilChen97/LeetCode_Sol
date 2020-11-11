import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        
        List<List<Integer>> pos = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            pos.add(new ArrayList<>());
        }
        for(int i = 0; i < ring.length(); i++){
            pos.get(ring.charAt(i)-'a').add(i);
        }

        int[][] dp = new int[key.length()][ring.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] =  Integer.MAX_VALUE;
            }
        }

        for(int num:pos.get(key.charAt(0)-'a')){
            dp[0][num] = Math.min(num, ring.length()-num) + 1;
        }

        for (int i = 1; i < key.length(); i++) {
            for (int j : pos.get(key.charAt(i) - 'a')) {
                for (int k : pos.get(key.charAt(i - 1) - 'a')) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), ring.length() - Math.abs(j - k)) + 1);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++){
            res = Math.min(res, dp[key.length()-1][i]);
        }
        return res;
    }
}