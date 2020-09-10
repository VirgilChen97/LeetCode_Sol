class Solution {
    int[] bucket;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        if (k == 1) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % k != 0){
            return false;
        }

        bucket = new int[k];
        Arrays.fill(bucket, sum/k);
        
        return dfs(k, nums, nums.length - 1);
    }

    public boolean dfs(int k, int[] nums, int cur) {
        if (cur < 0) {
            return true;
        }
        
        for (int i = 0; i < k; i++) {
            if (bucket[i] == nums[cur] || bucket[i] - nums[cur] >= nums[0]) {
                bucket[i] -= nums[cur];
                if (dfs(k, nums, cur - 1)) {
                    return true;
                }
                bucket[i] += nums[cur];
            }
        }
        return false;
    }
}