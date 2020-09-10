class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> pos = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == C){
                pos.add(i);
            }
        }

        int res[] = new int[S.length()];

        for(int i = 0; i < res.length; i++){
            int min = res.length;
            for(int p:pos){
                min = Math.min(min, Math.abs(i-p));
            }
            res[i] = min;
        }
        return res;
    }
}