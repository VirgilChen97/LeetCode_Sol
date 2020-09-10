import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> res = new HashMap<>();

        for (int i = 0; i < minSize; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        for (int i = minSize; i < s.length(); i++) {
            if (map.size() <= maxLetters) {
                String now = s.substring(i - minSize, i);
                if (!res.containsKey(now)) {
                    res.put(now, 0);
                }
                res.put(now, res.get(now) + 1);
            }

            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

            if (map.get(s.charAt(i - minSize)) == 1) {
                map.remove(s.charAt(i - minSize));
            } else {
                map.put(s.charAt(i - minSize), map.get(s.charAt(i - minSize)) - 1);
            }
        }

        if (map.size() <= maxLetters) {
            String now = s.substring(s.length() - minSize, s.length());
            if (!res.containsKey(now)) {
                res.put(now, 0);
            }
            res.put(now, res.get(now) + 1);
        }

        List<Integer> resArr = new ArrayList<>(res.values());
        if(resArr.size() == 0){
            return 0;
        }
        Collections.sort(resArr);
        return resArr.get(resArr.size() - 1);
    }
}