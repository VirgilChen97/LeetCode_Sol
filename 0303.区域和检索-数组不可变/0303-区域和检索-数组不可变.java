class NumArray {
    
    int sums[];
    int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        getSums();
    }
    
    public void getSums(){
        int sum=0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            sums[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0){
            return sums[j];
        }else{
            return sums[j]-sums[i-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */