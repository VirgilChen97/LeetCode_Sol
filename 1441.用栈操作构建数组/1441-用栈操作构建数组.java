class Solution {
    public List<String> buildArray(int[] target, int n) {
        int now = 1;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < target.length; i++){
            while(now != target[i]){
                res.add("Push");
                res.add("Pop");
                now++;
            }
            res.add("Push");
            now++;
        }
        return res;
    }
}