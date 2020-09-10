import java.util.*;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        for (int now : colsum) {
            if (now == 2) {
                upper--;
                lower--;
            }
        }
        for (int now : colsum) {
            if (now == 2) {
                up.add(1);
                down.add(1);
            } else if (now == 0) {
                up.add(0);
                down.add(0);
            } else {
                if (upper != 0) {
                    up.add(1);
                    down.add(0);
                    upper--;
                } else if (lower != 0) {
                    up.add(0);
                    down.add(1);
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        if (upper == 0 && lower == 0) {
            res.add(up);
            res.add(down);
        }
        return res;
    }
}