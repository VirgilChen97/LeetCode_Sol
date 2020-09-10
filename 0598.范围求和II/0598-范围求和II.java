import java.util.*;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mMin = m;
        int nMin = n;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0]<mMin){
                mMin = ops[i][0];
            }
            if(ops[i][1]<nMin){
                nMin = ops[i][1];
            }
        }
        return mMin * nMin;
    }
}