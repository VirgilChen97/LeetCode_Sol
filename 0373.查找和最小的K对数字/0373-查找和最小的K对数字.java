import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        List<List<Integer>> res = new LinkedList<>();
        if(nums1.length==0 || nums2.length == 0){
            return res;
        }

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[] { i, 0 });
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);
            if (pair[1] < nums2.length - 1) {
                queue.add(new int[] { pair[0], pair[1] + 1 });
            }
            res.add(item);
            k--;
        }
        return res;
    }
}