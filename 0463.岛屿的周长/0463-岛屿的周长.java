class Solution {
    public int islandPerimeter(int[][] grid) {
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int now = 4;
                    if(i > 0){
                        now -= grid[i-1][j];
                    }
                    if(j > 0){
                        now -= grid[i][j-1];
                    }
                    if(i < grid.length - 1){
                        now -= grid[i+1][j];
                    }
                    if(j < grid[0].length - 1){
                        now -= grid[i][j+1];
                    }
                    total += now;
                }
            }
        }
        return total;
    }
}