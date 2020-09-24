import java.util.*;

class Solution {
    class Grid {
        int row;
        int col;
        int val;

        public Grid(int _row, int _col, int _val) {
            row = _row;
            col = _col;
            val = _val;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        List<Grid> arr = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    Grid now = new Grid(i, j, forest.get(i).get(j));
                    arr.add(now);
                }
            }
        }
        Collections.sort(arr, (t1, t2) -> t1.val - t2.val);
        int row = 0;
        int col = 0;

        for (Grid now : arr) {
            int step = getSteps(row, col, now.row, now.col, forest);
            if(step == -1){
                return -1;
            }
            total += step;
            row = now.row;
            col = now.col;
        }

        return total;
    }

    public int getSteps(int srcRow, int srcCol, int dstRow, int dstCol, List<List<Integer>> forest) {
        int steps = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        Queue<Grid> q = new LinkedList<>();
        q.add(new Grid(srcRow, srcCol, forest.get(srcRow).get(srcCol)));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Grid now = q.poll();
                if (now.row == dstRow && now.col == dstCol) {
                    return steps;
                } else {
                    for (int[] direction : directions) {
                        if (0 <= now.row + direction[0] && now.row + direction[0] < forest.size()
                                && 0 <= now.col + direction[1] && now.col + direction[1] < forest.get(0).size()
                                && !visited[now.row + direction[0]][now.col + direction[1]]
                                && forest.get(now.row + direction[0]).get(now.col + direction[1]) != 0) {
                            q.add(new Grid(now.row + direction[0], now.col + direction[1],
                                    forest.get(now.row + direction[0]).get(now.col + direction[1])));
                            visited[now.row + direction[0]][now.col + direction[1]] = true;
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}