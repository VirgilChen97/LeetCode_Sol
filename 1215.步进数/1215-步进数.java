import java.util.*;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> countSteppingNumbers(int low, int high) {
        int depth = 0;
        int temp = high;
        while (temp != 0) {
            temp /= 10;
            depth++;
        }
        if(depth > 9){
            depth = 9;
        }
        generate(0, low, high, depth);
        Collections.sort(res);
        return res;
    }

    public void generate(int value, int low, int high, int depth) {
        if (value == 0) {
            for (int i = 0; i <= 9; i++) {
                if (low <= i && i <= high) {
                    res.add(i);
                }
            }
            for (int i = 1; i <= 9; i++) {
                generate(i, low, high, depth - 1);
            }
        } else {
            if (value < 214748360 && value % 10 - 1 >= 0) {
                int left = value * 10 + value % 10 - 1;
                if (low <= left && left <= high) {
                    res.add(left);
                }
                if (depth != 0) {
                    generate(left, low, high, depth - 1);
                }
            }
            if (value < 214748360 && value % 10 + 1 <= 9) {
                int right = value * 10 + value % 10 + 1;
                if (low <= right && right <= high) {
                    res.add(right);
                }
                if (depth != 0) {
                    generate(right, low, high, depth - 1);
                }
            }
        }
    }
}