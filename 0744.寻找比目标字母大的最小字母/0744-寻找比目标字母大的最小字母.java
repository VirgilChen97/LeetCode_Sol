class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length-1;
        while (l < r){
            int m = l + ((r - l) >> 1);
            if(letters[m] > target){
                r = m;
            }else{
                l = m + 1;
            }
        }
        if(target >= letters[l]){
            return letters[0];
        }else{
            return letters[r];
        }
    }
}