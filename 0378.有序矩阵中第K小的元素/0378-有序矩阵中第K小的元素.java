import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int[] row : matrix) {
            for (int num : row) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else {
                    if (queue.peek() > num) {
                        queue.poll();
                        queue.offer(num);
                    }
                }
            }
        }
        return queue.peek();
    }
}