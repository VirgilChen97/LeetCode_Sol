class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for(char a:s.toCharArray()){
            count[a - 'a']++;
        }
        for(char a:t.toCharArray()){
            count[a - 'a']--;
        }
        int res = 0;
        for(int i = 0; i < 26; i++){
            if(count[i]<0){
                res -= count[i];
            }
        }
        return res;
    }
}