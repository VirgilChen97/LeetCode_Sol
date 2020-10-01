import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];

        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                q.offer(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int neighbor : graph[now]) {
                        if (color[neighbor] == color[now]) {
                            return false;
                        } else if (color[neighbor] == 0) {
                            color[neighbor] = color[now] == 1 ? 2 : 1;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }

        return true;
    }
}