class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int w = nums.length;
        int h = nums[0].length;
        if(w*h!=r*c){
            return nums;
        }
        int temp[] = new int[r*c];
        int k = 0;
        int newNums[][] = new int[r][c];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                temp[k] = nums[i][j];
                k++;
            }
        }
        k=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = temp[k];
                k++;
            }
        }
        return newNums;
        
    }
}