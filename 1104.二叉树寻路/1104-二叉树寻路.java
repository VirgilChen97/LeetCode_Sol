import java.util.*;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 1;
        int curr = 1;
        List<Integer> res = new LinkedList<>();
        while(curr < label){
            level <<= 1;
            curr += level;
        }

        while(curr > 0){
            int big = curr;
            curr >>= 1;
            int small = curr + 1;
            int counter = small + big - label;
            res.add(0, label);
            if((counter & 1) == 0){
                label = counter / 2;
            }else{
                label = (counter - 1) / 2; 
            }
        }
        return res;
    }
}