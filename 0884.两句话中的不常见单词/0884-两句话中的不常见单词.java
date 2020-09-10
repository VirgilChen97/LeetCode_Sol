import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> mapA = new HashMap<>();
        HashMap<String, Integer> mapB = new HashMap<>();

        for(String now:A.split(" ")){
            if(!mapA.containsKey(now)){
                mapA.put(now, 0);
            }
            mapA.put(now, mapA.get(now)+1);
        }

        for(String now:B.split(" ")){
            if(!mapB.containsKey(now)){
                mapB.put(now, 0);
            }
            mapB.put(now, mapB.get(now)+1);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:mapA.entrySet()){
            if(!mapB.containsKey(entry.getKey()) && entry.getValue() < 2){
                list.add(entry.getKey());
            }
        }
        for(Map.Entry<String, Integer> entry:mapB.entrySet()){
            if(!mapA.containsKey(entry.getKey()) && entry.getValue() < 2){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[]{});
    }
}