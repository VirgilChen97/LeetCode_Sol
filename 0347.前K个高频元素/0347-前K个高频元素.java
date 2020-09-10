import java.util.*;
import java.util.Map.Entry;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num, map.get(num) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1) {
                if(arg0.getValue() > arg1.getValue()){
                    return -1;
                }else if(arg0.getValue() < arg1.getValue()){
                    return 1;
                }else{
                    return 0;
                }
            }
        };

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, comparator);

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(list.get(i).getKey());
        }

        return res;

    }
}