import java.util.*;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count= new HashMap<>();
        for(int card:deck){
            if(count.containsKey(card)){
                count.put(card, count.get(card)+1);
            }else{
                count.put(card, 1);
            }
        }
        int res = count.get(deck[0]);
        for(Map.Entry<Integer, Integer> entry:count.entrySet()){
            res = gcd(res, entry.getValue());
        }
        return res >= 2;
    }

    public int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : gcd(b, a % b);
    }
}