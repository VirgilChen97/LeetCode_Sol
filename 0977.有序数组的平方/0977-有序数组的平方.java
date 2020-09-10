class Solution {
    public int[] sortedSquares(int[] A) {
        int firstPositive = A.length;
        int [] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if(A[i] >= 0 && firstPositive == A.length){
                firstPositive = i;
            }
            A[i] = A[i]*A[i];
        }

        int neg = firstPositive - 1;
        int pos = firstPositive;
        int i = 0;
        for(; i < A.length && neg >= 0 && pos < A.length; i++){
            if(A[neg] < A[pos]){
                res[i] = A[neg--];
            }else{
                res[i] = A[pos++];
            }
        }

        while(neg >= 0){
            res[i++] = A[neg--];
        }

        while(pos < A.length){
            res[i++] = A[pos++];
        }

        return res;
    }
}