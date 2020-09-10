import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int count = 0;
        for(int i = 0; i < points.length; i++){
            count ++;
            int shot = points[i][1];
            while(i < points.length && points[i][0] <= shot){
                i++;
            }
            i--;
        }

        return count;
    }
}