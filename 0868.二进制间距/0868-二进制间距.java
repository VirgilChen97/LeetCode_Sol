class Solution {
    public int binaryGap(int N) {
        int count = 1;
        int max = 0;
        boolean prev = false;
        while(N!=0){
            int now = N & 1;
            N >>= 1;
            if(prev == false){
                if(now == 1){
                    prev = true;
                }
            }else{
                if(now == 1){
                    max = Math.max(count, max);
                    count = 1;
                }else{
                    count++;
                }
            }
        }
        return max;
    }
}