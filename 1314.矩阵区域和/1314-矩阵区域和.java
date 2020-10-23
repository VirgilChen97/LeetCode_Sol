class Solution {
    int[][] sum;
    public int[][] matrixBlockSum(int[][] mat, int K) {
        sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];
        for(int i = 1; i < mat.length; i++){
            sum[i][0] = mat[i][0] + sum[i-1][0];
        }
        for(int j = 1; j < mat[0].length; j++){
            sum[0][j] = mat[0][j] + sum[0][j-1];
        }

        for(int i = 1; i < mat.length; i++){
            for(int j = 1; j < mat[0].length; j++){
                sum[i][j] = mat[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int[][] res = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                res[i][j] = get(i+K,j+K) - get(i-K-1, j+K) - get(i+K, j-K-1) + get(i-K-1, j-K-1); 
            }
        }
        return res;
    }

    public int get(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i >= sum.length && j < sum[0].length){
            return sum[sum.length - 1][j];
        }else if(i < sum.length && j >= sum[0].length){
            return sum[i][sum[0].length - 1];
        }else if(i >= sum.length && j >= sum[0].length){
            return sum[sum.length - 1][sum[0].length - 1];
        }else{
            return sum[i][j];
        }
    }
}