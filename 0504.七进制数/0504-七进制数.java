import java.util.*;
class Solution {
    public String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        int isNegative = 0;
        if(num < 0){
            res.append('-');
            num = -num;
            isNegative = 1;
        }
        while(num!=0){
            int digit = num % 7;
            res.insert(isNegative, digit);
            num /= 7;
        }
        return res.toString();
    }
}