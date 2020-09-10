import java.util.*;
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        List<Integer> sum = new ArrayList<>();
        int end = (int)Math.floor(Math.sqrt(num));
        for (int i = 2; i <= end; i++) {
            if(num % i == 0){
                int j = num / i;
                sum.add(j);
                sum.add(i);
            }
        }
        sum.add(1);
        
        int sum1 = 0;
        for (int i = 0; i < sum.size(); i++) {
            sum1+=sum.get(i);
        }

        if(sum1 == num){
            return true;
        }else{
            return false;
        }
    }
}