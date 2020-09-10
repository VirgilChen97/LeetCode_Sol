class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int []wordsF = new int[words.length];
        for(int i = 0; i < words.length; i++){
            wordsF[i] = f(words[i]);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < res.length; i++){
            int count = 0;
            for(int j = 0; j < words.length; j++){
                int now = f(queries[i]);
                if(now < wordsF[j]){
                    count ++;
                }
            }
            res[i] = count;
        }
        return res;
    }
    
    public int f(String word){
        int count = 0;
        char now = 'z';
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) < now){
                count = 1;
                now = word.charAt(i);
            }else if(word.charAt(i) == now){
                count ++;
            }
        }
        return count;
    }
}