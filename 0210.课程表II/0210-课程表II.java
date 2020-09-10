import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map;
    int[] visited;
    Stack<Integer> stack;
    boolean isValid = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new int[numCourses];
        stack = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new LinkedList<Integer>());
        }
        for(int[] edge:prerequisites){
            map.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                topoSort(i);
            }
        }
        if(!isValid){
            return new int[0];
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    public void topoSort(int node){
        if(visited[node] == 1){
            isValid = false;
            return;
        }
        if(visited[node] == -1){
            return;
        }
        visited[node] = 1;
        List<Integer> connected = map.get(node);
        for(int next:connected){
            topoSort(next);
        }
        visited[node] = -1;
        stack.push(node);
    }
}