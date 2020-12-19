class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char a:s.toCharArray()){
            res ^= a;
        }
        for(char a:t.toCharArray()){
            res ^= a;
        }
        return res;
    }
}