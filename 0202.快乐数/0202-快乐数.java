class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            slow = nextHappy(slow);
            fast = nextHappy(nextHappy(fast));
        }while(slow != fast);
        if(fast == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public int nextHappy(int happy){
        int next = 0;
        while(happy!=0){
            int digit = happy%10;
            next += Math.pow(digit,2);
            happy /= 10;
        }
        return next;
    }
}