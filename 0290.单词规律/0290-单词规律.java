import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        Map<String, Character> mapping = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char now = pattern.charAt(i);
            if (map[now - 'a'] == null && !mapping.containsKey(words[i])) {
                map[now - 'a'] = words[i];
                mapping.put(words[i], now);
            } else if (map[now-'a'] != null && mapping.containsKey(words[i]) && map[now - 'a'].equals(words[i]) && mapping.get(words[i]) == now) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}