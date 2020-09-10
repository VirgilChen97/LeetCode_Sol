import java.util.*;

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int h = M.length;
        int w = M[0].length;
        int[][] res = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int sum = 0;
                int count = 1;
                // top right
                if(i!=0&&j!=0){
                    sum += M[i-1][j-1];
                    count++;
                }
                // top middle
                if(i!=0){
                    sum += M[i-1][j];
                    count++;
                }
                // top right
                if(i!=0&&j!=w-1){
                    sum += M[i-1][j+1];
                    count++;
                }
                // middle left
                if(j!=0){
                    sum += M[i][j-1];
                    count++;
                }
                // middle right
                if(j!=w-1){
                    sum += M[i][j+1];
                    count++;
                }
                // bottom left
                if(i!=h-1&&j!=0){
                    sum += M[i+1][j-1];
                    count++;
                }
                // bottom middle
                if(i!=h-1){
                    sum += M[i+1][j];
                    count++;
                }
                // bottom right
                if(i!=h-1&&j!=w-1){
                    sum += M[i+1][j+1];
                    count++;
                }
                // center
                sum += M[i][j];
                res[i][j] = (int)Math.floor((double)sum/count);
            }
        }
        return res;
    }
}