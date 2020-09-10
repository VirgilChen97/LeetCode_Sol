class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1){
            return;
        }
        k = k%nums.length;
        int position = nums.length - k - 1;
        reverse(nums,0,position);
        reverse(nums,position+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    
    public void reverse(int[]nums, int l, int r){
        while(l<r){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }
}