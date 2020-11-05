import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        int i = 0;
        while (i < list.size() - 1) {
            while (i < list.size() - 1 && list.get(i)[1] < list.get(i + 1)[0]) {
                i++;
            }
            int j = i + 1;
            while (j < list.size() && list.get(j)[1] < list.get(i)[1]) {
                list.remove(j);
            }

            if (j < list.size() && list.get(j)[0] <= list.get(i)[1]) {
                list.set(i, new int[] { list.get(i)[0], list.get(j)[1] });
                list.remove(j);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}