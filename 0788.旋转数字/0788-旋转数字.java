class Solution {
    public int rotatedDigits(int N) {
        int[] invertChange = {2,5,6,9};
        int[] invertUnchange = {0,1,8};
        Set<Integer> change = new HashSet<>();
        Set<Integer> unchange = new HashSet<>();
        for(int num:invertChange){
            change.add(num);
        }
        for(int num:invertUnchange){
            unchange.add(num);
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            int now = i;
            boolean isGood = false;
            while(now!=0){
                int digit = now % 10;
                if(change.contains(digit)){
                    isGood = true;
                }else if(unchange.contains(digit)){
                    now /= 10;
                    continue;
                }else{
                    isGood = false;
                    break;
                }
                now /= 10;
            }
            if(isGood) count ++;
        }
        return count;
    }
}