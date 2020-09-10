class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int []arr = new int [26];
        for(char a:licensePlate.toCharArray()){
            if('0' <= a && a <= '9' || a == ' '){
                continue;
            }else{
                if(a < 'a'){
                    arr[a - 'A']++;
                }else{
                    arr[a - 'a']++;
                }
            }
        }

        String res = null;
        for(String word:words){
            int[] temp = new int[26];
            for(int i = 0 ; i < 26;i++){
                temp[i] = arr[i];
            }
            boolean isValid = true;
            for(char a:word.toCharArray()){
                temp[a - 'a']--;
            }
            for(int i = 0 ; i < 26;i++){
                if(temp[i] > 0){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                if(res == null || word.length() < res.length()){
                    res = word;
                }
            }
        }
        return res;
    }
}