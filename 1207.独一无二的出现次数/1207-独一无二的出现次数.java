import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.computeIfAbsent(a, k->0);
            map.put(a, map.get(a) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer v:map.values()){
            if(set.contains(v)){
                return false;
            }else{
                set.add(v);
            }
        }
        return true;
    }
}