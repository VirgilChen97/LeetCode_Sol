import java.util.*;

class Solution {
    class UnionFind {
        int[] arr;
        int count;

        public UnionFind(int size) {
            arr = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot != bRoot) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == bRoot) {
                        arr[i] = aRoot;
                    }
                }
                count--;
            }
        }

        public int find(int a) {
            return arr[a];
        }

        public int getCount(){
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        UnionFind unionFind = new UnionFind(grid.length * grid[0].length);
        int waterCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    if(i > 0 && grid[i-1][j] == '1'){
                        unionFind.union(i*grid[0].length + j, (i-1)*grid[0].length + j);
                    }
                    if(j > 0 && grid[i][j-1] == '1'){
                        unionFind.union(i*grid[0].length + j, i*grid[0].length + j - 1);
                    }
                }else{
                    waterCount++;
                }
            }
        }
        return unionFind.getCount() - waterCount;
    }
}