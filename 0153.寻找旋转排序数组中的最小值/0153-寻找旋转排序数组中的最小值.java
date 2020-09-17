class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            if(nums[m] >= nums[0]){
                l = m + 1;
            }else if(nums[m] <= nums[nums.length - 1]){
                r = m;
            }
        }
        
        return nums[l];
    }
}