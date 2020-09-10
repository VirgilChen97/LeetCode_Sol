import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int []res = new int[2];
        int[] map = new int[nums.length];
        for (int num : nums) {
            map[num-1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(map[i]==0){
                res[1] = i+1;
            }else if(map[i]>1){
                res[0] = i+1;
            }
        }
        return res;
    }
}