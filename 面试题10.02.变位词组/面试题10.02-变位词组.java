class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] counts = new int[256];
            for(char a:str.toCharArray()){
                counts[a]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 256; i++){
                if(counts[i]!=0){
                    sb.append(counts[i]);
                    sb.append((char)i);
                }
            }
            
            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> group:map.values()){
            res.add(group);
        }
        return res;
    }
}