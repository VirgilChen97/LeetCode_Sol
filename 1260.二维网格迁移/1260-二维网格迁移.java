import java.util.*;
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int total = grid.length * grid[0].length;
        k = k % total;
        int[] copy = new int[total];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                copy[i*grid[0].length + j] = grid[i][j];
            }
        }

        List<Integer> now = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(now.size() == grid[0].length){
                res.add(now);
                now = new ArrayList<>();
            }
            now.add(copy[total - k + i]);
        }
        for(int i = k; i < total; i++){
            if(now.size() == grid[0].length){
                res.add(now);
                now = new ArrayList<>();
            }
            now.add(copy[i-k]);
        }
        if(now.size()!=0){
            res.add(now);
            now = new ArrayList<>();
        }
        return res;
    }
}