class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        if(nums[0] == nums[nums.length - 1]){
            while(l < r && nums[l] == nums[l + 1]){
                l++;
            }

            while(l < r && nums[r] == nums[r-1]){
                r--;
            }
        }
        
        if(nums[l] < nums[r]){
            return nums[l];
        }
        
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