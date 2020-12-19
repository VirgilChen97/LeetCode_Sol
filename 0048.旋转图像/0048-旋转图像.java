class Solution {
    public void rotate(int[][] matrix) {
        int w = matrix.length;
        int step = w / 2;
        
        for(int i = 0; i < step; i++){
            for(int j = 0; j < w - 2*i - 1; j++){
                int x = i, y = i + j, temp = matrix[x][y];
                for(int k = 0; k < 4; k++){
                    int z = y;
                    y = w - x - 1;
                    x = z;
                    z = temp;
                    temp = matrix[x][y];
                    matrix[x][y] = z;
                }
            }
        }
    }
}