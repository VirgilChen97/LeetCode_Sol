import java.util.*;

class Solution {
    class Grid{
        int row;
        int col;
        public Grid(int _row, int _col){
            row = _row;
            col = _col;
        }
    }
    public int maxDistance(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Grid> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.offer(new Grid(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        if(q.size() == grid.length * grid[0].length){
            return -1;
        }

        int res = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Grid now = q.poll();
                for(int[] direction:directions){
                    int nextX = now.row + direction[0];
                    int nextY = now.col + direction[1];
                    if(nextX >= 0 && nextX < grid.length && nextY >=0 && nextY < grid[0].length && !visited[nextX][nextY]){
                        q.offer(new Grid(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }
}