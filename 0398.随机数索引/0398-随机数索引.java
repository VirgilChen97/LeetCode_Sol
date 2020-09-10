import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> occur = new ArrayList<>();
                occur.add(i);
                map.put(nums[i], occur);
            }
        }
    }
    
    public int pick(int target) {
        List<Integer> occur = map.get(target);
        int pos = (int)(Math.random()*occur.size());
        return occur.get(pos);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */