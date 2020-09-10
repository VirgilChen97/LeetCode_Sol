import java.util.Arrays;

class KthLargest {

    int pq[];
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new int[k];
        Arrays.fill(pq, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (val > pq[0]) {
            pq[0] = val;
            adjust(0, k);
        }
        return pq[0];
    }

    public void adjust(int start, int end) {
        int temp = pq[start];
        for (int i = 2 * start + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end) {
                if (pq[i] > pq[i + 1]) {
                    i++;
                }
            }
            if (temp < pq[i]) {
                break;
            }
            pq[start] = pq[i];
            start = i;
        }
        pq[start] = temp;
    }
}