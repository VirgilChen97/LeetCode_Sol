import java.util.*;

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < 4; i++) {
            for (char a : instructions.toCharArray()) {
                if (a == 'L') {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction--;
                    }
                } else if (a == 'R') {
                    if (direction == 3) {
                        direction = 0;
                    } else {
                        direction++;
                    }
                } else {
                    x += directions[direction][0];
                    y += directions[direction][1];
                }
            }
        }

        return x == 0 && y == 0;
    }
}