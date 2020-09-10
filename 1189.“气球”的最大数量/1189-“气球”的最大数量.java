class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] counter = new int[26];
        for (int i = 0; i < text.length(); i++)
            counter[text.charAt(i) - 'a']++;
        counter[11] /= 2;
        counter[14] /= 2;
        int[] idx = new int[]{0, 1, 11, 13, 14};
        int res = Integer.MAX_VALUE;
        for (int i : idx) res = Math.min(res, counter[i]);
        return res;
    }
}