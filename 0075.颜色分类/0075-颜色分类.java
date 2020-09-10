class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for(int i = 0; i <= r; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                i--;
                r--;
            }
        }
    }
}