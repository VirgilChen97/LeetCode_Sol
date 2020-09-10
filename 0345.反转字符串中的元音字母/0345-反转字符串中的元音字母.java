class Solution {
    public String reverseVowels(String s) {
        char str[] = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(!isVowel(str[i]) && i < j ){
                i++;
            }
            while(!isVowel(str[j]) && i < j ){
                j--;
            }
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }
    
    public boolean isVowel(char s){
        if(s=='a' || s== 'e' || s=='i' || s=='o' || s=='u' || s=='A' || s== 'E' || s=='I' || s=='O' || s=='U'){
            return true;
        }else{
            return false;
        }
    }
}