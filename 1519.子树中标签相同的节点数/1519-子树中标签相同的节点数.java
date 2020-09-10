import java.util.*;

class Solution {
    int[] res;
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        res = new int[n];
        dfs(0, labels);
        return res;
    }

    public int[] dfs(Integer root, String labels) {
        int[] curr = new int[26];
        visited.add(root);
        for (Integer child : map.get(root)) {
            if (!visited.contains(child)) {
                int[] now = dfs(child, labels);
                for (int i = 0; i < 26; i++) {
                    curr[i] += now[i];
                }
            }
        }
        curr[labels.charAt(root) - 'a']++;
        res[root] = curr[labels.charAt(root) - 'a'];
        return curr;
    }
}