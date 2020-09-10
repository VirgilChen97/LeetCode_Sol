import java.util.*;

class Solution {
    char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || i == board.length - 1){
                    dfs(i, j);
                }else if(j == 0 || j == board[0].length - 1){
                    dfs(i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int row, int col){
        if(board[row][col] == 'O'){
            board[row][col] = '*';
            if(row - 1 > 0){
                dfs(row - 1, col);
            }
            if(row + 1 < board.length){
                dfs(row + 1, col);
            }
            if(col - 1 > 0){
                dfs(row, col - 1);
            }
            if(col + 1 < board[0].length){
                dfs(row, col + 1);
            }
        }else{
            return;
        }
    }
}