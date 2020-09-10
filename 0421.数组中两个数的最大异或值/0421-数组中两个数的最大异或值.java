class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if((nums[i] ^ nums[j]) > max){
                    max = nums[i] ^ nums[j];
                }
            }
        }
        return max;
    }
}