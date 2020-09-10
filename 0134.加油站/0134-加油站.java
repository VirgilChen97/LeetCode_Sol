import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int curr = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if(curr < 0){
                start = i + 1;
                curr = 0;
            }
        }
        if(total < 0){
            return -1;
        }else{
            return start;
        }
    }
}