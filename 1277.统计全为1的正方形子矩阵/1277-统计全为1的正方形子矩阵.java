class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] mat = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                sum += matrix[i][j];
                mat[i][j] = sum;
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            int sum = 0;
            for(int j = 0; j < matrix.length; j++){
                sum += mat[j][i];
                mat[j][i] = sum;
            }
        }

        int maxSquare = Math.min(matrix.length, matrix[0].length);

        for(int i = 1; i <= maxSquare; i++){
            for(int row = 0; row < matrix.length - i + 1; row ++){
                for(int col = 0; col < matrix[0].length - i + 1; col ++){
                    if(matrix[row][col] == 1){
                        if(isSquare(mat, row, col, row + i - 1, col + i - 1)){
                            count ++;
                        }
                    }
                }
            }
        }
        return count;

    }

    public boolean isSquare(int[][] matrix, int tlrow, int tlcol, int brrow, int brcol){
        int size = (brrow - tlrow + 1) * (brcol - tlcol + 1);
        int ones = matrix[brrow][brcol];
        if(tlrow != 0){
            ones -= matrix[tlrow - 1][brcol];
        }
        if(tlcol != 0){
            ones -= matrix[brrow][tlcol - 1];
        }
        if(tlcol != 0 && tlrow != 0){
            ones += matrix[tlrow - 1][tlcol - 1];
        }
        if(ones == size){
            return true;
        }else{
            return false;
        }
    }
}