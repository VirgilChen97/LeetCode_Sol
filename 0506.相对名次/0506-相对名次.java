import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int sorted[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, String> map = new HashMap<>();
        String[] name = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for(int i =0; i < sorted.length; i++){
            int position = sorted.length - i;
            if(position-1 < 3){
                map.put(sorted[i], name[position-1]);
            }else{
                map.put(sorted[i], ""+ (position));
            }
        }
        String res[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}