import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closed = 31928731;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            if(i!=0 && nums[i] == nums[i-1]) continue;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target){
                    if(Math.abs(sum-target)<Math.abs(closed - target)){
                        closed = sum;
                        while(l<r && nums[l] == nums[l+1]) l++;
                    }
                    l++;
                }else if(sum > target){
                    if(Math.abs(sum-target)<Math.abs(closed - target)){
                        closed = sum;
                        while(l<r && nums[r] == nums[r-1]) r--;
                    }
                    r--;
                }else{
                    return sum;
                }
            }
        }
        return closed;
    }
}