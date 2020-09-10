class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int[] resarr = new int[n];
        int count = 0;
        resarr[0] = 1;
        resarr[1] = 1;
        for(int i = 0; i <= Math.sqrt(n);i++){
            if(resarr[i] == 0){
                for(int j=2;j*i<n;j++){
                    resarr[i*j]=1;
                }
            }
        }
        for(int i = 0; i<n;i++){
            count += resarr[i];
        }
        return n-count;
    }
}