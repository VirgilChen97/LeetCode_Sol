class Solution {
    public int swimInWater(int[][] grid) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                l = Math.min(grid[i][j], l);
                r = Math.max(grid[i][j], r);
            }
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            boolean res = dfs(grid, new boolean[grid.length][grid.length], 0, 0, m);
            if (res) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int level) {
        if (row == grid.length - 1 && col == grid.length - 1 && grid[row][col] <= level) {
            return true;
        }
        if (grid[row][col] > level) {
            return false;
        }

        boolean res = false;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        visited[row][col] = true;
        for (int[] direction : directions) {
            if (row + direction[0] >= 0 && row + direction[0] < grid.length && col + direction[1] >= 0
                    && col + direction[1] < grid.length && !visited[row + direction[0]][col + direction[1]]) {
                res |= dfs(grid, visited, row + direction[0], col + direction[1], level);
            }
        }
        
        return res;
    }
}