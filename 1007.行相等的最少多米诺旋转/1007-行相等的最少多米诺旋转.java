class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int flipA = 0;
        int flipB = 0;
        int sameCount = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == B[i]){
                sameCount ++;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[0]) {
                continue;
            } else if (B[i] == A[0]) {
                flipA++;
            } else {
                flipA = -1;
                break;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (B[i] == B[0]) {
                continue;
            } else if (A[i] == B[0]) {
                flipB++;
            } else {
                flipB = -1;
                break;
            }
        }

        if (flipA == -1) {
            return Math.min(B.length - flipB - sameCount, flipB);
        } else if (flipB == -1) {
            return Math.min(A.length - flipA - sameCount, flipA);
        } else {
            return Math.min(Math.min(A.length - flipA - sameCount, flipA), Math.min(B.length - flipB - sameCount, flipB));
        }
    }
}