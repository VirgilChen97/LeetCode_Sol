class Solution {
    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int)Math.sqrt(c);
        while(start<=end){
            if(start*start+end*end > c){
                end --;
            }else if(start*start+end*end < c){
                start ++;
            }else{
                return true;
            }
        }
        return false;
    }
}