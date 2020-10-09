import java.util.*;

class Solution {
    int[] group;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        group = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            group[i] = i;
        }
        
        for(List<Integer> pair:pairs){
            union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Character>> chars = new HashMap<>();
        
        for(int i = 0; i < group.length; i++){
            chars.computeIfAbsent(find(group[i]), k ->new ArrayList<>());
            chars.get(find(group[i])).add(s.charAt(i));
        }

        for(List<Character> value:chars.values()){
            Collections.sort(value);
        }

        int[] ptrs = new int[group.length];
        char[] res = new char[group.length];
        for(int i = 0; i < res.length; i++){
            int group_num = find(group[i]);
            res[i] = chars.get(group_num).get(ptrs[group_num]++);
        }
        return new String(res); 
    }
    
    public int find(int a){
            if(group[a] != a){
                group[a] = find(group[a]);
                return group[a];
            }else{
                return a;
            }
        }
        
    public void union(int a, int b){
        group[find(b)] = find(a);
    }      
}