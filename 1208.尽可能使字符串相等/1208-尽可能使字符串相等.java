class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();
        int cost[] = new int[s1.length];
        int maxlength = 0;
        for (int i = 0; i < s1.length; i++) {
            cost[i] = Math.abs(s1[i] - t1[i]);
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < cost.length) {
            if (sum <= maxCost) {
                sum += cost[j];
                j++;
                if(sum <= maxCost){
                    maxlength = Math.max(maxlength, j - i);
                }
            }else{
                sum -= cost[i];
                i++;
            }
        }
        return maxlength;
    }
}