class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0; int r = A.length - 1;
        while (l < r){
            int m = l + ((r-l) >> 2) + 1;
            if(m==0 || A[m] > A[m-1]){
                l = m;
            }else{
                r = m - 1;
            }
        }
        return l;
    }
}