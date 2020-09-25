class Solution {
    Integer INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] edges, int N, int K) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < edges.length; j++) {
                //松弛
                if (dist[edges[j][0]] != INF && dist[edges[j][1]] > dist[edges[j][0]] + edges[j][2]) {
                    dist[edges[j][1]] = dist[edges[j][0]] + edges[j][2];
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; ++i) max = Math.max(max, dist[i]);
        return max == INF ? -1 : max;
    }
}