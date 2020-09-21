import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int from;

        public Pair(int val, int from) {
            this.val = val;
            this.from = from;
        }

        @Override
        public int compareTo(Solution.Pair arg0) {
            return this.val - arg0.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(matrix.length);
        int[] ptrs = new int[matrix.length];

        for (int i = 0; i < ptrs.length; i++) {
            q.add(new Pair(matrix[i][0], i));
            ptrs[i]++;
        }

        while (k > 1) {
            Pair now = q.poll();
            if (ptrs[now.from] < matrix[0].length) {
                q.add(new Pair(matrix[now.from][ptrs[now.from]++], now.from));
            }
            k--;
        }

        return q.poll().val;
    }
}