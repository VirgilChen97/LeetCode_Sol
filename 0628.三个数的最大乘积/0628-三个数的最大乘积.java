import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        int bigger = Integer.MIN_VALUE;
        int big = Integer.MIN_VALUE;
        int small = 0;
        int smaller = 0;
        for(int num:nums){
            if(num>biggest){
                big = bigger;
                bigger = biggest;
                biggest = num;
            }else if(num > bigger){
                big = bigger;
                bigger = num;
            }else if(num > big){
                big = num;
            }
            if(num < smaller){
                small = smaller;
                smaller = num;
            }else if(num<small){
                small = num;
            }
        }
        if(small < 0){
            return Math.max(small*smaller*biggest, big*bigger*biggest);
        }
        else{
            return big*bigger*biggest;
        }
    }
}