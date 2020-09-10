class Solution {
    public String tictactoe(int[][] moves) {
        char[][] chess = new char[3][3];
        boolean now = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                chess[i][j] = 'N';
            }
        }

        for (int i = 0; i < moves.length; i++) {
            if (now) {
                chess[moves[i][0]][moves[i][1]] = 'X';
            } else {
                chess[moves[i][0]][moves[i][1]] = 'O';
            }
            now = !now;
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (chess[i][j] == 'X') {
                    sum++;
                } else if (chess[i][j] == 'N') {
                    count++;
                }
            }
            if (sum == 3) {
                return "A";
            } else if (sum == 0) {
                if (count == 0) {
                    return "B";
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (chess[j][i] == 'X') {
                    sum++;
                } else if (chess[j][i] == 'N') {
                    count++;
                }
            }
            if (sum == 3) {
                return "A";
            } else if (sum == 0) {
                if (count == 0) {
                    return "B";
                }
            }
        }

        if (chess[1][1] == 'X') {
            if ((chess[0][0] == 'X' && chess[2][2] == 'X') || (chess[0][2] == 'X' && chess[2][0] == 'X')) {
                return "A";
            } else {
                if (moves.length == 9) {
                    return "Draw";
                }
            }
        }

        if (chess[1][1] == 'O') {
            if ((chess[0][0] == 'O' && chess[2][2] == 'O') || (chess[0][2] == 'O' && chess[2][0] == 'O')) {
                return "B";
            } else {
                if (moves.length == 9) {
                    return "Draw";
                }
            }
        }
        return "Pending";
    }
}