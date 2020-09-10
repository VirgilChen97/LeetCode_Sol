import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] arr = new int[26];
            for(char a:str.toCharArray()){
                arr[a - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append(arr[i]).append((char)(i+'a'));
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}