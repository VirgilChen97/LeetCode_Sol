import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String strs[] = str.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        Map<String, Character> map = new HashMap<String, Character>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(strs[i])){
                if(map.containsValue(pattern.charAt(i))){
                    return false;
                }
                map.put(strs[i], pattern.charAt(i));
            }else{
                if(map.get(strs[i])!=pattern.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}