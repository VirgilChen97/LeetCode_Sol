class Solution {
    public boolean checkRecord(String s) {
        int countL = 0;
        int countA = 0;
        char prev = 'C';
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A'){
                if(countA == 0){
                    countA ++;
                }else{
                    return false;
                }
            }else if(s.charAt(i) == 'L'){
                if(prev != 'L'){
                    countL = 1;
                }else{
                    countL ++;
                }
                if(countL > 2){
                    return false;
                }
            }
            prev = s.charAt(i);
        }
        return true;
    }
}