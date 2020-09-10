class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int var = prices[i] - prices[i - 1];
            if(var > 0){
                profit += var;
            }
        }
        return profit;
    }
}