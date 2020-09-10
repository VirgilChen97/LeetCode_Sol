class Solution {
    public int search(int[] nums, int target) {
        return binary(nums,0,nums.length-1,target);
    }
    public int binary(int[] nums, int l, int r, int target){
        if(l == r){
            if(nums[r] == target) return r;
            else return -1;
        }
        if(r < l){
            return -1;
        }
        int m = l + (r-l) / 2;
        if(nums[m]<target){
            return binary(nums,m+1,r,target);
        }else if(nums[m]>target){
            return binary(nums,l,m-1,target);
        }else{
            return m;
        }
    }
}