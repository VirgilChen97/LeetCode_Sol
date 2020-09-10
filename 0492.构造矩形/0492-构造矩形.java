class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        if (area != 0) {
            for (int i = (int) Math.floor(Math.sqrt(area)); i >= 1; i--) {
                if (area % i == 0) {
                    result[1] = i;
                    result[0] = area / i;
                    return result;
                }
            }

        }
        return result;
    }
}