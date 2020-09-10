class Solution {
    public int reachNumber(int target) {
        if(target < 0){
            target = - target;
        }
        int now = 1;
        int sum = 0;
        while(sum < target){
            sum += now;
            now++;
        }
        if(((sum & 1) == 0 && (target & 1) == 0) || ((sum & 1) == 1 && (target & 1) == 1)){
            return now - 1;
        }else{
            while((sum & 1)!=(target & 1)){
                sum +=now;
                now ++;
            }
            return now - 1;
        }
    }
}