import java.util.*;

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> candy = new HashSet<>();
        int totalCate = 0;
        for (int i = 0; i < candies.length; i++) {
            if(!candy.contains(candies[i])){
                totalCate ++;
                candy.add(candies[i]);
            }
            if(totalCate > candies.length/2){
                return candies.length/2;
            }
        }
        return totalCate;
    }
}