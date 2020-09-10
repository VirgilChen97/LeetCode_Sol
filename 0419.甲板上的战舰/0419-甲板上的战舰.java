class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    int plus = 1;
                    if(i-1>=0 && board[i-1][j] == 'X'){
                        plus = 0;
                    }
                    if(j-1>=0 && board[i][j-1] == 'X'){
                        plus = 0;
                    }
                    count += plus;
                }
            }
        }
        return count;
    }
}