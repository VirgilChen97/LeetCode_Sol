import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(k, (s1, s2) -> {
            if(map.get(s2) == map.get(s1)){
                return s2.compareTo(s1);
            }else{
                return map.get(s1) - map.get(s2);
            }
        });

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word)+1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                if (map.get(entry.getKey()) > map.get(queue.peek())) {
                    queue.poll();
                    queue.add(entry.getKey());
                }else if(map.get(entry.getKey()) == map.get(queue.peek()) && queue.peek().compareTo(entry.getKey()) > 0){
                    queue.poll();
                    queue.add(entry.getKey());
                }
            }
        }

        List<String> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(0, queue.poll());
        }
        return res;
    }
}