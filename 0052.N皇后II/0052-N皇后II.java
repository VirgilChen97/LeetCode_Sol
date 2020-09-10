import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int count;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        dfs(board, n);
        return count;
    }

    public void dfs(int[][] board, int left) {
        if (left == 0) {
            count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[left - 1][i] == 0) {
                put(board.length - left + 1, left - 1, i, board, true);
                dfs(board, left - 1);
                put(board.length - left + 1, left - 1, i, board, false);
            }
        }

    }

    public void put(int id, int row, int col, int[][] board, boolean op) {
        int[][] direction = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
                { -1, -1 } };
        board[row][col] = op ? id : 0;
        for (int i = 0; i < 8; i++) {
            int x = row;
            int y = col;
            while (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (op) {
                    if ((x != row || y != col) && board[x][y] == 0) {
                        board[x][y] = -id;
                    }
                } else {
                    if (board[x][y] == -id) {
                        board[x][y] = 0;
                    }
                }

                x += direction[i][0];
                y += direction[i][1];
            }
        }
    }
}