class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = reverse(words[i]);
        }
        return String.join(" ", words);
    }

    public String reverse(String s){
        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}