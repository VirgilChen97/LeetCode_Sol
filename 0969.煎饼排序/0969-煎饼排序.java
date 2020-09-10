import java.util.*;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++) {
            int pos = findMax(A, A.length - i);
            if (pos < A.length - i) {
                revert(A, pos + 1);
                res.add(pos + 1);
                revert(A, A.length - i);
                res.add(A.length - i);
            }
        }
        return res;
    }

    public int findMax(int[] A, int k) {
        int max = 0;
        int maxPos = -1;
        for (int i = 0; i < k; i++) {
            if (A[i] > max) {
                max = A[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    public void revert(int[] A, int k) {
        int l = 0;
        int r = k - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }
}