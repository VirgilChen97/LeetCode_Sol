import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            map.put(i, new LinkedList<Integer>());
        }
        for(int[] edge:prerequisites){
            map.get(edge[0]).add(edge[1]);
        }
        boolean res = true;
        for(int i = 0; i < numCourses; i++){
            if(visited[i]==0){
                res &= topoSort(i);
            }
        }
        return res;
    }

    public boolean topoSort(int node){
        List<Integer> connected = map.get(node);
        boolean isValid = true;
        visited[node] = 1;
        for(int next:connected){
            if(visited[next] == 1){
                isValid = false;
                break;
            }
            if(visited[next] == -1){
                continue;
            }
            isValid &= topoSort(next);
        }
        visited[node] = -1;
        return isValid;
    }
}