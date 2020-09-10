class Solution {
    public int trap(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxLeft[i] = height[i];
            } else {
                maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxRight[i] = height[i];
            } else {
                maxRight[i] = Math.max(height[i], maxRight[i + 1]);
            }
        }

        for (int i = 0; i < height.length; i++) {
            int wall = Math.min(maxLeft[i], maxRight[i]);
            if (wall > height[i]) {
                res += wall - height[i];
            }
        }

        return res;
    }
}