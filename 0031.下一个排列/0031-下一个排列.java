import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int prevMax = nums[nums.length-1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < prevMax){
                int biggerNumPos = i + 1;
                int biggerNum = nums[i+1];
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] > nums[i] && nums[j] < biggerNum){
                        biggerNum = nums[j];
                        biggerNumPos = j;
                    }
                }
                int temp = nums[biggerNumPos];
                nums[biggerNumPos] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }else{
                prevMax = Math.max(prevMax, nums[i]);
            }
        }

        Arrays.sort(nums);
        return;
    }
}