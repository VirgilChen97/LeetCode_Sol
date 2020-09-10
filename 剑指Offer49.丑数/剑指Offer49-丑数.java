class Solution {
    public boolean isUgly(int num) {
        if(num<=0){
            return false;
        }
        if(num==1){
            return true;
        }
        boolean flag = true;
        while(num!=1 && flag!=false){
            flag = false;
            if(num%2==0){
                num/=2;
                flag = true;
            }
            if(num%3==0){
                num/=3;
                flag = true;
            }
            if(num%5==0){
                num/=5;
                flag = true;
            }
        }
        return flag;
    }
}