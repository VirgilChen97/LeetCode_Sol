import java.util.*;

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][] sum = new int[4][N][N];
        int[][] map = new int[N][N];
        for(int[] mine: mines){
            map[mine[0]][mine[1]] = 1;
        }

        // up
        for(int i = N - 1; i >= 0; i--){
            for(int j = 0; j < N ; j++){
                if(map[i][j] == 0){
                    if(i < N - 1){
                        sum[0][i][j] = sum[0][i+1][j] + 1;
                    }else{
                        sum[0][i][j] = 1;
                    }
                }else{
                    sum[0][i][j] = 0;
                }
            }
        }

        // down
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                if(map[i][j] == 0){
                    if(i>0){
                        sum[1][i][j] = sum[1][i-1][j] + 1;
                    }else{
                        sum[1][i][j] = 1;
                    }
                }else{
                    sum[1][i][j] = 0;
                }
            }
        }

        // left
        for(int i = 0; i < N; i++){
            for(int j = N - 1; j >= 0 ; j--){
                if(map[i][j] == 0){
                    if(j < N - 1){
                        sum[2][i][j] = sum[2][i][j+1] + 1;
                    }else{
                        sum[2][i][j] = 1;
                    }
                }else{
                    sum[2][i][j] = 0;
                }
            }
        }

        //right
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                if(map[i][j] == 0){
                    if(j > 0){
                        sum[3][i][j] = sum[3][i][j-1] + 1;
                    }else{
                        sum[3][i][j] = 1;
                    }
                }else{
                    sum[3][i][j] = 0;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                int localMin = N;
                for(int k = 0; k < 4; k++){
                    localMin = Math.min(localMin, sum[k][i][j]);
                }
                res = Math.max(res, localMin);
            }
        }


        return res;
    }
}