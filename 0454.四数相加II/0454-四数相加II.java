class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:A){
            for(int b:B){
                if(!map.containsKey(a + b)){
                    map.put(a+b, 1);
                }else{
                    map.put(a+b, map.get(a+b) + 1);
                }
            }
        }
        for(int c:C){
            for(int d:D){
                int now = c + d;
                if(map.containsKey(-now)){
                    count+=map.get(-now);
                }
            }
        }
        return count;
    }
}