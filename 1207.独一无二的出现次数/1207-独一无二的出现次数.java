import java.util.*;
import java.util.Map.Entry;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if(set.contains(entry.getValue())){
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}