class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int empty = 0;
        while(numBottles > 0){
            total += numBottles;
            empty += numBottles;
            int newGet = (int) Math.floorDiv(empty, numExchange);
            empty -= newGet * numExchange;
            numBottles = newGet;
        }
        return total;
    }
}