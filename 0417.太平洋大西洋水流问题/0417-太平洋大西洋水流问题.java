class Solution {
    private int row, col;
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };
    private boolean inArea(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    private void dfs(int x, int y, int[][] matrix, int[][] travelled){
        travelled[x][y] = 1;
        for(int[] d : directions){
            int newx = x + d[0];
            int newy = y + d[1];
            if(!inArea(newx, newy) || matrix[x][y] > matrix[newx][newy] || travelled[newx][newy] == 1)
                continue;
            dfs(newx, newy, matrix, travelled);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        row = matrix.length;
        col = matrix[0].length;
        int[][] pcf = new int[row][col];
        int[][] atl = new int[row][col];
        for(int i = 0; i < row; i++){
            dfs(i, 0, matrix, pcf);
            dfs(i, col-1, matrix, atl);
        }
        for(int i = 0; i < col; i++){
            dfs(0, i, matrix, pcf);
            dfs(row-1, i, matrix, atl);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pcf[i][j] == 1 && atl[i][j] == 1)
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
}