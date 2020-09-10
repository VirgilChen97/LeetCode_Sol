class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        int res = -1;

        Queue<Pair> lands = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    lands.add(new Pair(i,j));
                }
            }
        }

        if(lands.size() == 0 || lands.size() == grid.length * grid[0].length){
            return res;
        }
        
        while(!lands.isEmpty()){
            int landsCount = lands.size();
            for(int i = 0; i < landsCount; i++){
                Pair nowLand = lands.poll();
                grid[nowLand.x][nowLand.y] = -1;
                if(nowLand.x - 1 >= 0 && grid[nowLand.x - 1][nowLand.y] == 0){
                    grid[nowLand.x - 1][nowLand.y] = -1;
                    lands.add(new Pair(nowLand.x - 1,nowLand.y));
                }
                if(nowLand.x + 1 < grid.length && grid[nowLand.x + 1][nowLand.y] == 0){
                    grid[nowLand.x + 1][nowLand.y] = -1;
                    lands.add(new Pair(nowLand.x + 1, nowLand.y));
                }
                if(nowLand.y - 1 >=0 && grid[nowLand.x][nowLand.y-1] == 0){
                    grid[nowLand.x][nowLand.y - 1] = -1;
                    lands.add(new Pair(nowLand.x, nowLand.y-1));
                }
                if(nowLand.y + 1 < grid[0].length && grid[nowLand.x][nowLand.y+1] == 0){
                    grid[nowLand.x][nowLand.y + 1] = -1;
                    lands.add(new Pair(nowLand.x, nowLand.y+1));
                }
            }
            res ++;
        }
        return res;
    }
}