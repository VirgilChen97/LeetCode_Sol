import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < nums.length && l <= r) {
            if (map.lastKey() - map.firstKey() <= limit) {
                res = Math.max(res, r - l + 1);
                r++;
                if (r < nums.length) {
                    map.computeIfAbsent(nums[r], k -> 0);
                    map.put(nums[r], map.get(nums[r]) + 1);
                }
            } else {
                if (map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.get(nums[l]) - 1);
                }
                l++;
            }
        }
        return res;
    }
}