class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(slow != fast || fast == 0){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        for(int i = 0; i != slow; i = nums[i]){
            slow = nums[slow];
        }
        return slow;
    }
}