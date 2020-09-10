import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] > nums[(m+1)%nums.length]){
                return nums[(m+1)%nums.length];
            }
            if(nums[m] >= nums[0]){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
}