class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char a: s.toCharArray()){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }else{
                map.put(a, map.get(a) + 1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2)->o2.getValue()-o1.getValue());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry:list){
            for(int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}