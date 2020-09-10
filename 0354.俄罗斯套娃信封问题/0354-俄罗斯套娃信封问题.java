class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2)->o1[0]-o2[0] == 0 ? (o2[1]-o1[1]) : (o1[0]-o2[0]));
        int[] h = new int[envelopes.length];
        for(int i = 0; i < h.length; i++){
            h[i] = envelopes[i][1];
        }
        return lengthOfLIS(h);
    }

    public int lengthOfLIS(int[] nums) {
        int opt[] = new int[nums.length];
        for(int i = 0; i < opt.length; i++){
            opt[i] = 1;
        }
        for(int i = 0; i < opt.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    opt[i] = Math.max(opt[i], opt[j]+1);
                }
            }
        }
        int res = 0;
        for(int num:opt){
            if(num > res){
                res = num;
            }
        }
        return res;
    }
}