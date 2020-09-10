import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int maxPos = -1;
            int max = -1;
            dp.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp.get(j).size() > max) {
                        max = dp.get(j).size();
                        maxPos = j;
                    }
                }
            }
            if (maxPos >= 0) {
                dp.set(i, new ArrayList<>(dp.get(maxPos)));
            }
            dp.get(i).add(nums[i]);
        }

        int max = 0;
        int pos = 0;
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i).size() > max) {
                max = dp.get(i).size();
                pos = i;
            }
        }
        return dp.get(pos);
    }
}