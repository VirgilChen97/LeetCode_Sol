import java.util.*;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = nums[0];
        boolean hasMin = false;
        int min = Integer.MAX_VALUE;
        while(j < nums.length){
            if(sum < s){
                j++;
                if(j < nums.length){
                    sum += nums[j];
                }
            }else{
                hasMin = true;
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        if(hasMin){
            return min;
        }else{
            return 0;
        }
    }
}