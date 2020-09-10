import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int[][] pre = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = 0;
                if (i > 0) {
                    sum += pre[i - 1][j];
                }
                if (j > 0) {
                    sum += pre[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum -= pre[i - 1][j - 1];
                }
                pre[i][j] = sum + matrix[i][j];
            }
        }

        for (int x1 = 0; x1 < matrix.length; x1++) {
            for (int y1 = 0; y1 < matrix[0].length; y1++) {
                for (int x2 = x1; x2 < matrix.length; x2++) {
                    for (int y2 = y1; y2 < matrix[0].length; y2++) {
                        int sum = pre[x2][y2];
                        if (x1 > 0) {
                            sum -= pre[x1 - 1][y2];
                        }
                        if (y1 > 0) {
                            sum -= pre[x2][y1 - 1];
                        }
                        if(x1 > 0 && y1 > 0){
                            sum += pre[x1-1][y1-1];
                        }
                        if(sum == target){
                            count ++;
                        }
                    }
                }
            }
        }
        return count;
    }
}