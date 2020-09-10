class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for(List<String> path:paths){
            if(!map.containsKey(path.get(0))){
                map.put(path.get(0), 0);
            }
            if(!map.containsKey(path.get(1))){
                map.put(path.get(1), 0);
            }
            map.put(path.get(0), map.get(path.get(0)) + 1);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() == 0){
                return entry.getKey();
            }
        }
        return "";
    }
}