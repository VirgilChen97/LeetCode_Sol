class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0){
            num -= (2*i-1);
            i++;
        }
        if(num==0){
            return true;
        }else{
            return false;
        }
    }
}