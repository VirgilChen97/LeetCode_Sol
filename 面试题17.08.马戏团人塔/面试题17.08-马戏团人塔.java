import java.util.*;

class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] res = new int[height.length][2];
        for(int i = 0; i < height.length; i++){
            res[i][0] = height[i];
            res[i][1] = weight[i];
        }

        Arrays.sort(res, new Comparator<int[]>(){
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[0]==arg1[0]){
                    return arg1[1] - arg0[1];
                }
                return arg0[0] - arg1[0];
            }
        });

        int [] dp = new int[height.length];
        int max = 0;
        for(int[] p:res){
            int i=0,j=max;
            while(i<j){
                int mid = i+(j-i)/2;
                if(dp[mid]<p[1])    i = mid+1;
                else    j = mid;
            }
            dp[i] = p[1];
            if(max==j)  max++;
        }
        return max;
    }
}