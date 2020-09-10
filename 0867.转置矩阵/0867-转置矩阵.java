class Solution {
    public int[][] transpose(int[][] A) {
        int[] data = new int[A[0].length * A.length];
        int [][] AT = new int[A[0].length][A.length];
        int k = 0;
        for(int[] line:A){
            for(int num:line){
                data[k] = num;
                k++;
            }
        }
        k=0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                AT[j][i] = data[k];
                k++;
            }
        }
        return AT;
    }
}