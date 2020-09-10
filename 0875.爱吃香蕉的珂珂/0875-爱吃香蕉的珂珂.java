class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for(int pile:piles){
            if(pile > max){
                max = pile;
            }
        }
        int l = 1;
        int r = max;

        while(l < r){
            int m = l + (r-l) / 2;
            int totalTime = 0;
            for(int pile:piles){
                totalTime += (pile-1) / m + 1;
            }
            if(totalTime <= H){
                r = m;
            }else{
                l = m + 1; 
            }
        }
        return l;
    }
}