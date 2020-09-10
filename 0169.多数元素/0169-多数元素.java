class Solution {
    public int majorityElement(int[] nums) {
        int current = 0;
        int score = 0;
        for(int i = 0; i < nums.length; i++){
            if(score == 0) {
                current = i;
                score=1;
            }else {
                if (nums[current] == nums[i]) score++;
                if (nums[current] != nums[i]) score--;
            }
        }
        return nums[current];
    }
}