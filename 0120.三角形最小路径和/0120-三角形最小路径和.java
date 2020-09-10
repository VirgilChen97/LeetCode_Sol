import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >=0; i--){
            List<Integer> thisRow = triangle.get(i);
            List<Integer> prevRow = triangle.get(i+1);
            for(int j = 0; j <= i; j++){
                thisRow.set(j, thisRow.get(j) + Math.min(prevRow.get(j), prevRow.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}