import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = -1;
        int end = -2;
        int max = nums[0];
        int min = nums[n-1];
        int i=0, j=n-1;
        while(i<n && j >= 0){
            max = Math.max(nums[i], max);
            min = Math.min(nums[j], min);
            if(nums[i]<max){
                end = i;
            }
            if(nums[j]>min){
                start = j;
            }
            i++;
            j--;
        }
        return end - start + 1;
    }
}