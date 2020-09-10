class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diff = n - m;
        int bits = 0;
        while(diff != 0){
            diff /= 2;
            bits ++;
        }
        int a = m & n;
        for(int i = 0; i < bits; i++){
            a >>= 1;
        }
        for(int i = 0; i < bits; i++){
            a <<= 1;
        }
        return a;
    }
}