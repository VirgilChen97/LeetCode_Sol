import java.util.*;

class Solution {
    int[] group;

    public int[] findRedundantConnection(int[][] edges) {
        group = new int[edges.length + 1];
        for(int i = 0; i < edges.length; i++){
            group[i] = i;
        }

        int[] res = new int[]{0,0};

        for(int [] edge:edges){
            if(!union(edge[0], edge[1])){
                res = edge;
                break;
            }
        }

        return res;
    }

    public boolean union(int a, int b){
        int gA = find(a);
        int gB = find(b);
        if(gA == gB){
            return false;
        }else{
            group[gA] = gB;
            return true;
        }
    }

    public int find(int a){
        if(group[a] == a){
            return a;
        }else{
            group[a] = find(group[a]);
            return group[a];
        }
    }
}