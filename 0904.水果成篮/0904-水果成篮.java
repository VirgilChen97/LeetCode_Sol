import java.util.*;

class Solution {
    public int totalFruit(int[] tree) {
        int a = -1;
        int aposition = -1;
        boolean isA = false;
        int b = -1;
        int bposition = -1;
        boolean isB = false;
        int prev = -1;
        int i = 0, j = 0, max = 0;
        while(j < tree.length){
            if(prev == tree[j]){
                j++;
                max = Math.max(max, j - i);
                continue;
            }else if(!isA ||!isB){
                if(!isA){
                    a = tree[j];
                    aposition = j;
                    isA = true;
                }else{
                    b = tree[j];
                    bposition = j;
                    isB = true;
                }
            }else if(a!=tree[j] && b!=tree[j]){
                if(bposition > aposition){
                    a = tree[j];
                    aposition = j;
                    i = bposition;
                }else{
                    b = tree[j];
                    bposition = j;
                    i = aposition;
                }
            }else if(a == tree[j]){
                aposition = j;
            }else if(b == tree[j]){
                bposition = j;
            }
            max = Math.max(max, j - i + 1);
            prev = tree[j];
            j++;
        }
        return max;
    }
}