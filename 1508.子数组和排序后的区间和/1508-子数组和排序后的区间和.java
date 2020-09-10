import java.util.*;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int p = 1000000007;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            long res = nums[i] % p + preSum[i-1];
            preSum[i] = (int)(res % p);
        }

        int[] allSum = new int[n*(n+1)/2];
        int k = 0;
        for(int i = 0; i < n; i++){
            allSum[k++] = preSum[i];
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                allSum[k++] = preSum[j] - preSum[i];
            }
        }
        Arrays.sort(allSum);
        
        int res = 0;
        for(int i = left - 1; i <= right - 1; i++){
            res = (res + allSum[i]) % p;
        }
        return res;
    }
}