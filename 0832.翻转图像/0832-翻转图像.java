class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            int l = 0, r = A[0].length - 1;
            while(l <= r){
                int temp = invert(A[i][l]);
                A[i][l] = invert(A[i][r]);
                A[i][r] = temp;
                l++;
                r--;
            }
        }
        return A;
    }

    public int invert(int num){
        return 1 ^ num;
    }
}