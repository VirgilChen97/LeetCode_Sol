class Solution {
    public boolean validMountainArray(int[] A) {
        int state = -1;
        for(int i = 1; i < A.length; i++){
            if(state == -1){
                if(A[i] < A[i-1]){
                    return false;
                }else{
                    state = 0;
                }
            }else if(state == 0){
                if(A[i] < A[i-1]){
                    state = 1;
                }
                if(A[i] == A[i-1]){
                    return false;
                }
            }else{
                if(A[i] >= A[i-1]){
                    return false;
                }
            }
        }
        return state == 1;
    }
}