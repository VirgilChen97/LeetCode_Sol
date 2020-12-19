class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[1] = poured;
        for(int i = 1; i <= query_row; i++){
            double[] temp = new double[query_row + 2];
            for(int j = 1; j <= i+1 ; j++){
                if(res[j-1] > 1){
                    temp[j] += (res[j-1] - 1)/2;
                }
                if(res[j] > 1){
                    temp[j] += (res[j] - 1)/2;
                }
            }
            res = temp;
        }
        return Math.min(1, res[query_glass + 1]);
    }
}