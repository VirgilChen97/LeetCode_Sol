import java.util.*;

class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(click[0], click[1]));
        board[row][col] = 'B';

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            int count = 0;
            for (int[] direction : directions) {
                if (now.row + direction[0] >= 0 && now.row + direction[0] < board.length && now.col + direction[1] >= 0
                        && now.col + direction[1] < board[0].length) {
                    if (board[now.row + direction[0]][now.col + direction[1]] == 'M') {
                        count++;
                    }
                }
            }

            if (count == 0) {
                for (int[] direction : directions) {
                    if (now.row + direction[0] >= 0 && now.row + direction[0] < board.length
                            && now.col + direction[1] >= 0 && now.col + direction[1] < board[0].length) {
                        if (board[now.row + direction[0]][now.col + direction[1]] == 'E') {
                            board[now.row + direction[0]][now.col + direction[1]] = 'B';
                            queue.add(new Pair(now.row + direction[0], now.col + direction[1]));
                        }
                    }
                }
            } else {
                board[now.row][now.col] = (char) ('0' + count);
            }
        }

        return board;
    }
}