class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = l + ((r-l)>>1);
            if(nums[m] == target){
                return m;
            }else{
                // 左半边有序
                if(nums[m] >= nums[l]){
                    if(target >= nums[l] && target < nums[m]){
                        r = m - 1;
                    }else{
                        l = m + 1;
                    }
                }else{ //右半边有序
                    if(target > nums[m] && target <= nums[r]){
                        l = m + 1;
                    }else{
                        r = m - 1;
                    }
                }
            }
        }
        return -1;
    }
}