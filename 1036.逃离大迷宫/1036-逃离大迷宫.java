import java.util.*;

class Solution {
    class Grid {
        int row;
        int col;

        public Grid(int _row, int _col) {
            row = _row;
            col = _col;
        }

        @Override
        public int hashCode() {
            return row * 100000 + col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Grid))
                return false;
            Grid grid = (Grid) obj;
            return grid.row == row && grid.col == col;
        }
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Grid> blocks = new HashSet<>();
        for (int block[] : blocked)
            blocks.add(new Grid(block[0], block[1]));
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }

    public boolean bfs(int[] source, int[] target, Set<Grid> blocks) {
        int dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        Set<Grid> visited = new HashSet<>();
        visited.add(new Grid(source[0], source[1]));
        Queue<Grid> q = new LinkedList<>();
        q.offer(new Grid(source[0], source[1]));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Grid now = q.poll();
                for (int dir[] : dirs) {
                    int nextRow = now.row + dir[0];
                    int nextCol = now.col + dir[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= 1e6 || nextCol >= 1e6) continue;
                    Grid nextStep = new Grid(nextRow, nextCol);
                    if (visited.contains(nextStep) || blocks.contains(nextStep))
                        continue;
                    if (nextRow == target[0] && nextCol == target[1])
                        return true;
                    q.offer(nextStep);
                    visited.add(nextStep);
                }
                if (q.size() >= 200)
                    return true;
            }
        }
        return false;
    }
}