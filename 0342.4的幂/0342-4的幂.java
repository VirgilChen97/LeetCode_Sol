class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0 || (num&(num-1))!=0){
            return false;
        }
        if((num & 0x55555555) == num){
            return true;
        }else{
            return false;
        }
    }
}