import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n == 0){
            res.add(0);
        }else{
            res.add(0);
            res.add(1);
            for(int i = 1; i < n; i++){
                generate(res, i);
            }
        }
        return res;
    }
    public void generate(List<Integer> res, int digit){
        int size = res.size();
        int one = 1;
        one <<= digit;
        for(int i = size - 1; i >= 0; i--){
            res.add(one | res.get(i));
        }
    }
}