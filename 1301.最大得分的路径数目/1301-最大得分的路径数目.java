import java.util.*;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int h = board.size();
        int w = board.get(0).length();
        int mod = (int) 1e9 + 7;

        int dpCount[][] = new int[h][w];
        int dpMax[][] = new int[h][w];
        int[][] directions = new int[][] { { 1, 0 }, { 1, 1 }, { 0, 1 } };
        dpCount[h - 1][w - 1] = 1;

        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                for (int[] direction : directions) {
                    int prevI = direction[0] + i;
                    int prevJ = direction[1] + j;
                    if (board.get(i).charAt(j) == 'X') {
                        continue;
                    }
                    if (prevI >= 0 && prevI < h && prevJ >= 0 && prevJ < w && board.get(prevI).charAt(prevJ) != 'X') {
                        if (dpMax[prevI][prevJ] > dpMax[i][j] - board.get(i).charAt(j) + '0') {
                            dpCount[i][j] = dpCount[prevI][prevJ];
                            dpMax[i][j] = (dpMax[prevI][prevJ] % mod + (board.get(i).charAt(j) - '0') % mod) % mod;
                        } else if (dpMax[prevI][prevJ] == dpMax[i][j] - board.get(i).charAt(j) + '0') {
                            dpCount[i][j] = (dpCount[i][j] % mod + dpCount[prevI][prevJ] % mod) % mod;
                        }
                    }
                }
            }
        }

        if (dpCount[0][0] == 0) {
            return new int[] { 0, 0 };
        }

        return new int[] { dpMax[0][0] + '0' - 'E', dpCount[0][0] };
    }
}