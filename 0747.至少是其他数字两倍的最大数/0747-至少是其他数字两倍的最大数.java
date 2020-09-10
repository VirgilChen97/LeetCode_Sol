class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int maxPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                maxPos = i;
            }
        }
        if(check(nums, max)){
            return maxPos;
        }else{
            return -1;
        }

    }

    public boolean check(int[] nums, int max){
        boolean isBig = true;
        for(int num:nums){
            if(num == max){
                continue;
            }
            if(num << 1 > max){
                return false;
            }
        }
        return true;
    }
}