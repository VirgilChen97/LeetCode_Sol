import java.util.*;

class Solution {
    public boolean judgeCircle(String moves) {
        int a = 0;
        int b = 0;
        for(char now:moves.toCharArray()){
            if(now == 'U') a++;
            if(now == 'D') a--;
            if(now == 'L') b++;
            if(now == 'R') b--;
        }
        if(a==0&&b==0){
            return true;
        }else{
            return false;
        }
    }
}