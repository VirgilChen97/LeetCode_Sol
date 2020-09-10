class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int row[] = new int[n];
        int col[] = new int[m];
        for(int indice[]:indices){
            row[indice[0]]++;
            col[indice[1]]++;
        }
        int count = 0;
        for(int r:row){
            for(int l:col){
                if(((r+l)&1)==1){
                    count++;
                }
            }
        }
        return count;
    }
}