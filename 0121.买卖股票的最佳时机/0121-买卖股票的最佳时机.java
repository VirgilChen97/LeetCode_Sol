class Solution {
    public int maxProfit(int[] prices) {
        int min = 999999;
        int max_prev = 0;
        for(int i = 0; i< prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            }
            if(prices[i]-min > max_prev){
                max_prev = prices[i] - min;
            }
        }
        return max_prev;
    }
}