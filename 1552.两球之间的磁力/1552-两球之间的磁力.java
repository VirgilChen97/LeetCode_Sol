import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1] / (m - 1);
        while(l < r){
            int count = 1;
            int c = l + ((r - l + 1) >> 1);
            int prevPos = position[0];
            for(int pos:position){
                if(pos - prevPos >= c){
                    prevPos = pos;
                    count ++;
                }
            }
            if(count >= m){
                l = c;
            }else{
                r = c - 1;
            }
        }
        return l;
    }
}