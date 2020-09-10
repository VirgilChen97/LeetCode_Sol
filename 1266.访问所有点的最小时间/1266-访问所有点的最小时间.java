class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        for(int i = 1; i < points.length; i++){
            int x = Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1] - points[i-1][1]);
            while(x > 0 && y > 0){
                x--;
                y--;
                total++;
            }
            while(x > 0){
                x--;
                total++;
            }
            while(y>0){
                y--;
                total++;
            }
        }
        return total;
    }
}