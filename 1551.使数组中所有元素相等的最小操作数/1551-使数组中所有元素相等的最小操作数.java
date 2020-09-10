class Solution {
    public int minOperations(int n) {
        int l = 1;
        int r = 2 * (n - 1) + 1;
        int res = 0;
        while(l < r){
            res += (r - l) / 2;
            l += 2;
            r -= 2;
        }
        return res;
    }
}