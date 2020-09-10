class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(count[nums[i]] == 0){
                start[nums[i]] = i; 
            }
            count[nums[i]]++;
            end[nums[i]] = i;
            if(count[nums[i]] > count[max]){
                max = nums[i];
            }else if(count[nums[i]] == count[max]){
                if(end[nums[i]]- start[nums[i]] < end[max] - start[max]){
                    max = nums[i];
                }
            }
        }
        return end[max] - start[max] + 1;
    }
}