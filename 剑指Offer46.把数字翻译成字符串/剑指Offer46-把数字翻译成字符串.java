class Solution {
    public int translateNum(int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            list.add(0, digit);
            num /= 10;
        }

        if(list.size() <= 1){
            return 1;
        }

        int[] dp = new int[list.size()];
        dp[0] = 1;

        if(list.get(0) * 10 + list.get(1) < 26){
            dp[1] = 2;
        }else{
            dp[1] = 1;
        }

        for(int i = 2; i < dp.length; i++){
            dp[i] += dp[i-1];
            if(list.get(i-1) != 0 && list.get(i-1) * 10 + list.get(i) < 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[dp.length - 1];
    }
}