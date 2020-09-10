class Solution {
    public int countPrimeSetBits(int L, int R) {
        int prime[] = {2,3,5,7,11,13,17,19,23,29,31};
        HashSet<Integer> primes = new HashSet<>();
        int res = 0;
        for(int n:prime){
            primes.add(n);
        }
        for(int i = L; i <= R; i++){
            int now = i;
            int count = 0;
            while(now!=0){
                count += now & 1;
                now >>= 1;
            }
            if(primes.contains(count)){
                res ++;
            }
        }
        return res;
    }
}